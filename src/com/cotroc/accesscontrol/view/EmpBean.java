package com.cotroc.accesscontrol.view;

import com.cotroc.accsesscontrol.blogic.DuplicatedDataException;
import com.cotroc.accsesscontrol.blogic.BLEmp;
import com.cotroc.accsesscontrol.blogic.CustomException;
import com.cotroc.accsesscontrol.model.Employee;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="empBean")
public class EmpBean {

	private Employee employee = new Employee();
	private Employee empByCi;
	private String statusMessage;
	private String ci;
	
	public EmpBean() {
		
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
	
	public void setEmployee(Employee emp) {
		this.employee = emp;
	}

	public Employee getEmpByCi() {
		return this.empByCi;
	}
	
	public void setEmpByCi(Employee emp) {
		this.empByCi = emp;
	}
	
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String successMessage) {
		this.statusMessage = successMessage;
	}
	
	public String getCi() {
		return this.ci;
	}
	
	public void setCi(String ci) {
		this.ci = ci;
	}

	public void findEmpByCi() {
		empByCi = null;
		try {
			empByCi = BLEmp.findByCi(ci);
			statusMessage = empByCi.getName();
			if (empByCi == null) {
				statusMessage = "no existe empleado con cedula " + employee.getCi();
			}
		} catch (CustomException e) {
			statusMessage = e.getMessage();
		}
	}
	
	public void newEmp() {
		try {
			BLEmp.create(employee);
			statusMessage = employee.getName() + " created.";
			employee = null;
		} catch (CustomException e) {
			statusMessage = e.getMessage();
		} catch (DuplicatedDataException e) {
			statusMessage = e.getMessage();
		}
	}
}
