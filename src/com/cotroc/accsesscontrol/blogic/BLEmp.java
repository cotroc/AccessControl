package com.cotroc.accsesscontrol.blogic;

import java.util.ArrayList;

import com.cotroc.accsesscontrol.model.EmpDAO;
import com.cotroc.accsesscontrol.model.Employee;

public class BLEmp {
		
	public static Employee create(Employee emp) throws CustomException, DuplicatedDataException {
		return EmpDAO.create(emp);
	}
	 
	public static Employee findByCi(String ci) throws CustomException {
		return EmpDAO.findByCi(ci);
	}
	
 	public static ArrayList<Employee> getAllEmployees() {
		return EmpDAO.getAllEmployees();
	}
		
 	
	public static Employee login(Employee emp) throws DuplicatedDataException, CustomException {
		
		Employee employee = null;
		/*
		Employee byCi = EmpDAO.findByCi(emp.getCi());
		Employee byAndroid_id = EmpDAO.findByAndroid_id(emp.getAndroid_id());
		
		if(byCi == null)
			throw new CustomException(NoUserByCi + emp.getCi());
		
		if(byCi.getAndroid_id() != null) {
			if(byCi.getCi().equals(byAndroid_id.getCi())) {
				employee = byCi;
			} else {
				throw new DuplicatedDataException(IncorrectDevice + byAndroid_id.getName());
			}
		} else {
			EmpDAO.addAndroidId(emp);
			employee = EmpDAO.findByCi(emp.getCi());
		}
		*/
		return employee;
	}
	
}