package com.cotroc.accsesscontrol.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cotroc.accsesscontrol.model.Employee;

public class DbEmployee {
	
	public static Employee create(Employee emp) {
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
        	  emp.setId((int)rs.getLong(1));
		} catch (SQLException e) {
			emp = null;
			System.out.println(e.getMessage());
		}
		return emp;
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
	
	public static Employee findByCi(String ci) {
		Employee emp = null;
		try {
			String query = "SELECT * FROM employee where ci=?";
		    Connection conn = DbConn.getDataSource().getConnection();
		    PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		    preparedStmt.setString(1, ci);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public static boolean existCi(String ci) {
		if(findByCi(ci) == null) {
			return false;
		} else {
			return true;
		}
	}
	
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
}
