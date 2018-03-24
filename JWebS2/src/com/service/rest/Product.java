/**
 * 
 */
package com.service.rest;  
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;  
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;  
@Path("/product")  
public class Product{  
   
	@POST  
    @Path("/add")  
    public Response addUser(  
        @FormParam("id") int id,  
        @FormParam("name") String name,  
        @FormParam("price") float price) {  
   
        return Response.status(200)  
            .entity(" Product added successfuly!<br> Id: "+id+"<br> Name: " + name+"<br> Price: "+price)  
            .build();  
    }  
    
    
    @POST  
    @Produces(MediaType.TEXT_HTML)       
    @Path("/view") 
    public String sayHtmlHello( @FormParam("id") int id,  
            @FormParam("name") String name,  
            @FormParam("price") float price) {  
      return "<html> " + "<title>" + "Hello Jersey" + "</title>"  
          + "<body><h1>" + id + "</h1></body>" + "</html> ";  
    }  
    
    
}             