package com.cotroc.accsesscontrol.blogic;

import java.util.ArrayList;

import com.cotroc.accsesscontrol.dao.EmpDAO;
import com.cotroc.accsesscontrol.model.Employee;

public class EmpBL {
	
	public static Employee create(Employee emp) throws DuplicatedDataException, NoDataException {
		Employee empCreated = null;
		if(checkForNull(emp.getName(), emp.getAddress(),
						emp.getCi(), emp.getTel())) {
			throw new NoDataException("Faltan datos");
		}
		if(EmpDAO.existCi(emp.getCi())) {
			throw new DuplicatedDataException("Cedula duplicada");
		} else {
			empCreated = EmpDAO.create(emp);
		}
		return empCreated;
	}
	 
	public static ArrayList<Employee> getAllEmployees() {
		return EmpDAO.getAllEmployees();
	}
		
	public static Employee login(Employee emp) throws DuplicatedDataException, NoDataException {
		if(checkForNull(emp.getCi(), emp.getAndroid_id()))
			throw new NoDataException("Faltan datos");
		
		Employee employee = null;
		Employee byCi = EmpDAO.findByCi(emp.getCi());
		Employee byAndroid_id = EmpDAO.findByAndroid_id(emp.getAndroid_id());
		
		if(byCi == null)
			throw new NoDataException("No existe emp con ci " + emp.getCi());
		
		if(byCi.getAndroid_id() != null) {
			if(byCi.getCi().equals(byAndroid_id.getCi())) {
				employee = byCi;
			} else {
				throw new DuplicatedDataException("Dispositivo correspondiente a " + byAndroid_id.getName());
			}
		} else {
			EmpDAO.addAndroidId(emp);
			employee = EmpDAO.findByCi(emp.getCi());
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
