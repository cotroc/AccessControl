package com.cotroc.accsesscontrol.ws;

import com.cotroc.accsesscontrol.blogic.BlEmployee;
import com.cotroc.accsesscontrol.model.Employee;

import java.util.ArrayList;

public class RcEmployee {
	
	public static ResponseWrapper createEmployee(Employee emp) {
		ResponseWrapper rw;
		Employee empCreated =  BlEmployee.create(emp);
		if(empCreated != null) {
			rw = new ResponseWrapper(true, emp.getName() + " creado con exito", empCreated);
		} else {
			rw = new ResponseWrapper(false, "no se pudo crear", null);
		}
		return rw;
	}
	
	public static ResponseWrapper getAllEmployees() {
		ArrayList<Employee> empList = BlEmployee.getAllEmployees();
		return new ResponseWrapper(true, "Lista de empleados", empList);
	}
	
	public static ResponseWrapper findEmployeeByCi(String ci) {
		String statsMsg;
		Employee empByCi = BlEmployee.findByCi(ci);
		if(empByCi != null) {
			statsMsg ="Encontrado " + empByCi.getName();
		} else {
			statsMsg = "No se encuenta emp con cedula: " + ci;
		}
		return new ResponseWrapper((empByCi != null), statsMsg, empByCi);
	}
	
	public static ResponseWrapper addAndroidId(Employee emp) {
		boolean empToUpdate = BlEmployee.addAndroidId(emp);
		return new ResponseWrapper(empToUpdate, emp.getName() + " actualizado", emp);
	}
	
	public static ResponseWrapper checkAndroidId(String ci, String id) {
		String statsMsg;
		Employee empChecked = BlEmployee.checkAndroidId(ci, id);
		if(empChecked != null) {
			statsMsg = "Bienvenid@ " + empChecked.getName();
		} else {
			statsMsg = "Dispositivo invalido para " + BlEmployee.findByCi(ci).getName();
		}
		return new ResponseWrapper((empChecked != null), statsMsg, empChecked);
	}
	
}
