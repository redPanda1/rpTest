package com.redPanda.DWTest.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/redPanda")
@Produces(MediaType.APPLICATION_JSON)

public class redPanda {
	
	  @GET
	  @Path("/{id}")
	  public Response getPanda  (@PathParam("id") int id) {
	    // retrieve information about the contact with the provided id
	    // ...
	    return Response
	        .ok("{\"message\": \"redPanda Lives!\" }")
	        .build();
	  }
	
	  @GET
	  @Path("/")
	  public Response errorResponse  (@PathParam("id") int id) {
	    // retrieve information about the contact with the provided id
	    // ...
	    return Response
	        .ok("{\"message\": \"You must specify a parameter\" }")
	        .build();
	  }
	
}
