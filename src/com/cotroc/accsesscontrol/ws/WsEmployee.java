package com.cotroc.accsesscontrol.ws;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cotroc.accsesscontrol.model.Employee;
import com.cotroc.accsesscontrol.model.WorkingDay;

@Path ("/employee")
public class WsEmployee {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public ResponseWrapper getAllUsers(){
		return RcEmployee.getAllEmployees();
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public ResponseWrapper createEmployee(Employee emp){
       return RcEmployee.createEmployee(emp);
    }
	
	@Path("/{ci}")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseWrapper findEmployeeByCi(@PathParam("ci")String ci) {
		return null; //RcEmployee.findEmployeeByCi(ci);
    }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deviceid")
	public ResponseWrapper addAndroidId(Employee emp) {
		return RcEmployee.addAndroidId(emp);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/checkid")
	public ResponseWrapper checkAndroidId(Employee emp) {
		return null; //RcEmployee.checkAndroidId(emp.getCi(), emp.getAndroid_id());
	}
	/*
	@Path("/checkid/{ci}/{android_id")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseWrapper checkAndroidId(@PathParam("ci") String ci, @PathParam("android_id") String id) {
		return EmpControllerResponse.checkAndroidId(ci, id);
    }
    */
}
