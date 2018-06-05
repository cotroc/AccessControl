package com.cotroc.accsesscontrol.ws;

import com.cotroc.accsesscontrol.blogic.BLEmp;
import com.cotroc.accsesscontrol.blogic.CustomException;
import com.cotroc.accsesscontrol.blogic.DuplicatedDataException;
import com.cotroc.accsesscontrol.model.Employee;

import java.util.ArrayList;

public class RcEmployee {
	
	public static ResponseWrapper createEmployee(Employee emp) {
		boolean success = false;
		Employee empCreated = null;
		String message = null;
		try {
			empCreated = BLEmp.create(emp);
			success = true;
			message = empCreated.getName() + " creado.";
		} catch(DuplicatedDataException e) {
			message = e.getMessage();
		} catch (CustomException e) {
			message = e.getMessage();
		}
		return new ResponseWrapper(success, message, empCreated);
	}
	
	public static ResponseWrapper getAllEmployees() {
		ArrayList<Employee> empList = BLEmp.getAllEmployees();
		return new ResponseWrapper(true, "Lista de empleados", empList);
	}
	
	public static ResponseWrapper login(Employee emp) {
		boolean success = false;
		Employee logedEmp = null;
		String message = null;
		
		try {
			logedEmp = BLEmp.login(emp);
			success = true;
			message = logedEmp.getName() + " conectado";
		} catch(CustomException e) {
			message = e.getMessage();
		} catch(DuplicatedDataException e) {
			message = e.getMessage();
		}
		return new ResponseWrapper(success, message, logedEmp);
	}
}
