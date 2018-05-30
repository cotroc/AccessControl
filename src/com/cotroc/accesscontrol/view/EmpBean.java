package com.cotroc.accesscontrol.view;

import com.cotroc.accsesscontrol.blogic.DuplicatedDataException;
import com.cotroc.accsesscontrol.blogic.BLEmp;
import com.cotroc.accsesscontrol.blogic.CustomException;
import com.cotroc.accsesscontrol.blogic.NoDataException;
import com.cotroc.accsesscontrol.model.Employee;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="empBean")
public class EmpBean {

	private Employee employee = new Employee();
	private Employee empByCi;
	private String statusMessage;
	
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

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String successMessage) {
		this.statusMessage = successMessage;
	}

	public Employee findEmpByCi() {
		Employee empByCi = null;
		try {
			empByCi = BLEmp.findByCi(employee.getCi());
		} catch (NoDataException e) {
			statusMessage = e.getMessage();
		}
		
		return empByCi;
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
		} catch (NoDataException e) {
			statusMessage = e.getMessage();
		}
	}
}
