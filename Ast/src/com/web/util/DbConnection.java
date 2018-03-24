package com.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
 private static DbConnection instance;
 Connection conn;

 private DbConnection() {
  init();
 }

 public static synchronized DbConnection getInstance() {
  if (instance == null) {
   instance = new DbConnection();
  }
  return instance;
 }

 private void init() {
  ClassLoader classloader = (DbConnection.class).getClassLoader();
  URL url = classloader.getResource("db.properties");
  Properties properties = new Properties();
  try {
   InputStream inputstream = url.openStream();
   properties.load(inputstream);
   Class.forName(properties.getProperty("drivers"));
   String dbUrl = properties.getProperty("conn.url");
   String dbUser = properties.getProperty("conn.user");
   String dbPass = properties.getProperty("conn.pass");
   System.out.println(dbUrl + "--" + dbUser + "--" + dbPass);
   conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
  } catch (IOException ioe) {
   System.out.println("dbConn IOException -> " + ioe.toString());
  } catch (SQLException sqle) {
   System.out.println("dbConn SQLException -> " + sqle.toString());
  } catch (ClassNotFoundException cnfe) {
   System.out.println("dbConn ClassNotFoundException -> " + cnfe.toString());
  }
 }

 public Connection getConnection() {
  try {
   init();
  } catch (Exception e) {
   System.out.println("DbConnection Exception : " + e);
  }
  return conn;
 }

 
}
