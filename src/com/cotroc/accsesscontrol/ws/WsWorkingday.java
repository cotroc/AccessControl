package com.cotroc.accsesscontrol.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cotroc.accsesscontrol.model.WorkingDay;

@Path ("/workingday")
public class WsWorkingday {
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public ResponseWrapper createWorkingDay(WorkingDay wday){
		return null;
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update")
    public ResponseWrapper updateWorkingDay(WorkingDay wday){
       return null;
    }
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getplaces")
	public ResponseWrapper getPlaces() {
		return RcPlace.getAllPlaces();
	}

}
