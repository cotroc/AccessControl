package com.cotroc.accsesscontrol.blogic;

import java.util.ArrayList;

import com.cotroc.accsesscontrol.model.Employee;
import com.cotroc.accsesscontrol.persistence.DbEmployee;

public class BlEmployee {
	
	public static Employee create(Employee emp) {
		Employee empCreated = null;
		if(DbEmployee.existCi(emp.getCi())) {
			System.out.println("ya existe empleado con cedula " + emp.getCi());
		} else {
			empCreated = DbEmployee.create(emp);
		}
		return empCreated;
	}
	
	public static ArrayList<Employee> getAllEmployees() {
		return DbEmployee.getAllEmployees();
	}
	
	public static Employee findByCi(String ci) {
		return DbEmployee.findByCi(ci);
	}

	public static boolean addAndroidId(Employee emp) {
		return DbEmployee.addAndroidId(emp);
	}
	
	
	public static Employee checkAndroidId(String ci, String id) {
		return DbEmployee.checkAndroidId(ci, id);
	}
	
}
