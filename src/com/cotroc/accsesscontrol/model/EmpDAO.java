package com.cotroc.accsesscontrol.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cotroc.accsesscontrol.blogic.CustomException;
import com.cotroc.accsesscontrol.blogic.DuplicatedDataException;

public class EmpDAO {
	
	public static Employee create(Employee emp) throws CustomException, DuplicatedDataException {
		Employee empCreated = null;
		
		if (existCi(emp.getCi())) {
			throw new DuplicatedDataException("Ya existe empleado con cedula " + emp.getCi());
		}
		
		if( emp == null || checkForNull(
				emp.getName(),
				emp.getAddress(),
				emp.getCi(), 
				emp.getTel())) {
			throw new CustomException("Faltan datos");
		}
		
		try {
			String query = "insert into employee (ci, name, address, tel) values (?, ?, ?, ?)";
		      Connection conn;
		      conn = DbConn.getDataSource().getConnection();
		      PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		      preparedStmt.setString(1, emp.getCi());
		      preparedStmt.setString (2, emp.getName());
		      preparedStmt.setString(3, emp.getAddress());
		      preparedStmt.setString(4, emp.getTel());
		      preparedStmt.execute();
	          ResultSet rs = preparedStmt.getGeneratedKeys();
	          if(rs.next()) {
	        	  empCreated = emp;
	        	  empCreated.setId((int)rs.getLong(1));
	          } 
		} catch (SQLException e) {
			throw new CustomException("No se pudo crear " + emp.getName() , e);
		}
		return empCreated;
	}
	
	public static Employee update(Employee emp) throws CustomException {
		Employee empUpdated = null;
		
		return empUpdated;
	}
	
 	public static ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			Connection conn = DbConn.getDataSource().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
			while (rs.next()) {
					Employee e = new Employee();
					e.setId(rs.getInt("id"));
					e.setCi(rs.getString("ci"));
					e.setName(rs.getString("name"));
					e.setAddress(rs.getString("address"));
					e.setTel(rs.getString("tel"));
					e.setAndroid_id(rs.getString("android_id"));
					list.add(e);
			}
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	/*
	public static Employee findByAndroid_id(String android_id) {
		Employee emp = null;
		try {
			String query = "SELECT * FROM employee where android_id=?";
		    Connection conn = DbConn.getDataSource().getConnection();
		    PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		    preparedStmt.setString(1, android_id);
		    ResultSet rs = preparedStmt.executeQuery();
		    System.out.println(preparedStmt.toString());
		    while (rs.next()) {
		    	emp = new Employee();
		    	emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setCi(rs.getString("ci"));
				emp.setAddress(rs.getString("address"));
				emp.setTel(rs.getString("tel"));
				emp.setAndroid_id(rs.getString("android_id"));
		    }
			conn.close();
			preparedStmt.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	*/
	
	public static Employee findByCi(String ci) throws CustomException{
		
		if(ci.equals(""))
			throw new CustomException("Falta cedula");
		
		Employee emp = null;
		try {
			String query = "SELECT * FROM employee where ci=?";
		    Connection conn = DbConn.getDataSource().getConnection();
		    PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		    preparedStmt.setString(1, ci);
		    ResultSet rs = preparedStmt.executeQuery();
		    if (rs.next()) {
		    	emp = new Employee();
		    	emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setCi(rs.getString("ci"));
				emp.setAddress(rs.getString("address"));
				emp.setTel(rs.getString("tel"));
				emp.setAndroid_id(rs.getString("android_id"));
		    } 
			conn.close();
			preparedStmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new CustomException("SQL Error", e);
		}
		return emp;
	}
	
	public static boolean existCi(String ci) throws CustomException {
		boolean exist = true;
		if(findByCi(ci) == null) {
			return false;
		}
		return exist;
	}
	
	/*
	public static boolean addAndroidId(Employee emp) {
		boolean added = false;
		try {
		      String query = "UPDATE employee SET android_id=? WHERE ci=?";
		      Connection conn;
		      conn = DbConn.getDataSource().getConnection();
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, emp.getAndroid_id());
		      preparedStmt.setString(2, emp.getCi());
		      preparedStmt.execute();
		      if(preparedStmt.executeUpdate() > 0) {
		    	  added = true;
		      }
		      conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return added;
	}
	*/
	
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
