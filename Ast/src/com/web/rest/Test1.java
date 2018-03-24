package com.web.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.web.rest.dao.PersonDao;
import com.web.rest.dto.Person;
import com.web.util.DbConnection;

@Path("/t")
public class Test1 {

	@GET
	@Produces(MediaType.TEXT_HTML)

	public String ss() {
		return "rrrr fff";
	}

	@GET
	@Path("/t1/{p}")
	public Response getMsg(@PathParam("p") String p) {
		String out = " ---> " + p;
		return Response.status(200).entity(out).build();
	}

	@Path("/json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg1() {
		List<Person> l = new ArrayList<Person>();
		PersonDao pdao = new PersonDao();
		try {
			l = pdao.getList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return Response.status(200).entity(l).build();
	}

	@Path("/xml")
	@GET   
	@Produces(MediaType.APPLICATION_XML)
	public Response getMsg11() {
		List<Person> l = new ArrayList<Person>();
		PersonDao pdao = new PersonDao();
		try {
			l = pdao.getList();
 
		} catch (Exception e) {

			e.printStackTrace();
		}

		return Response.status(200).entity(l).build();
	}

	@Path("/story/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg1(@PathParam("id") int id) {
		List<Person> l = new ArrayList<Person>();
		PersonDao pdao = new PersonDao();
		try {
			l = pdao.getListbyId(id);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return Response.status(200).entity(l).build();
	}

}
