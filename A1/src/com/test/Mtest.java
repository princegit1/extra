package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mtest {
	
	public static void main(String ss[]) throws Exception
	{
		  // Creating a Mongo client 
	      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 

	      // Creating Credentials 
	      MongoCredential credential;
	      credential = MongoCredential.createCredential("a1", "test1", 
	         "password".toCharArray()); 
	      System.out.println("Connected to the database successfully");  
	      
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("test1");  
	      
	      // Retrieving a collection 
	      MongoCollection<Document> collection = database.getCollection("col1");
	      System.out.println("Collection sampleCollection selected successfully"); 

	      // Getting the iterable object 
	      FindIterable<Document> iterDoc = collection.find(); 
	      int i = 1; 

	      // Getting the iterator 
	      Iterator it = iterDoc.iterator(); 
	    
	      while (it.hasNext()) {  
	         System.out.println(it.next());  
	      i++; 
	      }
	   } 
	}
  
  