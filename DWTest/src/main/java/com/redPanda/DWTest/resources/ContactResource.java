package com.redPanda.DWTest.resources;

import java.net.UnknownHostException;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.redPanda.DWTest.representations.Contact;

@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)

 

public class ContactResource {
	
	
	  @GET
	  @Path("/{id}")
	  public Response getContact(@PathParam("id") int id) {
	    // retrieve information about the contact with the provided id
		  
		  
			
	  MongoClient client;
	  DB database = null;
	  try {
		  client = new MongoClient();
		  database = client.getDB("course");
	  } catch (UnknownHostException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
	   
	  DBCollection collection = database.getCollection("hello");
	  DBObject document = collection.findOne();
	  System.out.println(document);
	  
	  Contact contact = new Contact( id, "John", "Doe", "+123456789");		  

	    return Response
	        .ok( contact )
	        .build();
	  }
	
	  
	  @POST
	  public Response createContact(Contact contact) {
	    // store the new contact 
	    // ...
	    return Response
	        .created(null)
	        .build();
	  }
	  
	  @DELETE
	  @Path("/{id}")
	  public Response deleteContact(@PathParam("id") int id) {
	    // delete the contact with the provided id
	    // ...
	    return Response
	        .noContent()
	        .build();
	  }
	  
	  @PUT
	  @Path("/{id}")
	  public Response updateContact(
	      @PathParam("id") int id, Contact contact) {
	    // update the contact with the provided ID
	    // ...
	    return Response
	          .ok(new Contact(id, contact.getFirstName(), contact.getLastName(), contact.getPhone()))
	          .build();
	    }
}
