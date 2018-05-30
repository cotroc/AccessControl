package com.cotroc.accsesscontrol.blogic;

import java.util.ArrayList;

import com.cotroc.accsesscontrol.model.EmpDAO;
import com.cotroc.accsesscontrol.model.Employee;

public class BLEmp {
	
	private final static String NoData = "Faltan datos.";
	private final static String NoUserByCi = "Cedula ingresada no existe: ";
	private final static String IncorrectDevice = "Dispositivo incorrecto, correspondiente a: ";
	private final static String EmptyString = "";
	
	public static Employee create(Employee emp) throws CustomException, DuplicatedDataException, NoDataException {
		return EmpDAO.create(emp);
	}
	 
	public static Employee findByCi(String ci) throws NoDataException {
		return EmpDAO.findByCi(ci);
	}
	
 	public static ArrayList<Employee> getAllEmployees() {
		return EmpDAO.getAllEmployees();
	}
		
	public static Employee login(Employee emp) throws DuplicatedDataException, NoDataException {
		
		Employee employee = null;
		Employee byCi = EmpDAO.findByCi(emp.getCi());
		Employee byAndroid_id = EmpDAO.findByAndroid_id(emp.getAndroid_id());
		
		if(byCi == null)
			throw new NoDataException(NoUserByCi + emp.getCi());
		
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
		return employee;
	}
	
		private static boolean checkForNull(Object... objects) {
			boolean isNull = false;
			for(Object o : objects) {
				if(o == null || o.equals(EmptyString)) {
					isNull = true;
				}
			}
			return isNull;
		}
}