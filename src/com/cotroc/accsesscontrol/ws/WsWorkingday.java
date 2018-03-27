package com.cotroc.accsesscontrol.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cotroc.accsesscontrol.model.Wday;

@Path ("/workingday")
public class WsWorkingday {
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public ResponseWrapper createWorkingDay(Wday wday){
		//System.out.println(wday.toString());
		return RcWday.saveWdayData(wday);
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update")
    public ResponseWrapper updateWorkingDay(Wday wday){
       return null; //RcWorkingday.updateWorkingDay(wday);
    }
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/savewday")
    public ResponseWrapper saveWdayData(Wday wday){
		System.out.println("WsWorkingday >> " + wday.getPunch_in().toString());
        return RcWday.saveWdayData(wday);
    }
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/placelist")
	public ResponseWrapper getPlaces() {
		return RcPlace.getAllPlaces();
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getWday")
	public ResponseWrapper getWday() {
		
		return null;
	}
	
}
