package com.cotroc.accsesscontrol.blogic;

import java.util.ArrayList;

import com.cotroc.accsesscontrol.model.Employee;
import com.cotroc.accsesscontrol.persistence.DbEmployee;

public class EmployeeDao {
	
	public static Employee create(Employee emp) throws DuplicatedDataException, NoDataException {
		Employee empCreated = null;
		if(checkForNull(emp.getName(), emp.getAddress(),
						emp.getCi(), emp.getTel())) {
			throw new NoDataException("Faltan datos");
		}
		if(DbEmployee.existCi(emp.getCi())) {
			throw new DuplicatedDataException("Cedula duplicada");
		} else {
			empCreated = DbEmployee.create(emp);
		}
		return empCreated;
	}
	 
	public static ArrayList<Employee> getAllEmployees() {
		return DbEmployee.getAllEmployees();
	}
		
	public static Employee login(Employee emp) throws DuplicatedDataException, NoDataException {
		if(checkForNull(emp.getCi(), emp.getAndroid_id()))
			throw new NoDataException("Faltan datos");
		
		Employee employee = null;
		Employee byCi = DbEmployee.findByCi(emp.getCi());
		Employee byAndroid_id = DbEmployee.findByAndroid_id(emp.getAndroid_id());
		
		if(byCi == null)
			throw new NoDataException("No existe emp con ci " + emp.getCi());
		
		if(byCi.getAndroid_id() != null) {
			if(byCi.getCi().equals(byAndroid_id.getCi())) {
				employee = byCi;
			} else {
				throw new DuplicatedDataException("Dispositivo correspondiente a " + byAndroid_id.getName());
			}
		} else {
			DbEmployee.addAndroidId(emp);
			employee = DbEmployee.findByCi(emp.getCi());
		}
		return employee;
	}
	
	private static boolean checkForNull(Object... objects) {
		boolean isNull = false;
		for(Object o : objects) {
			if(o == null || o.equals("")) {
				isNull = true;
			}
		}
		return isNull;
	}
}
