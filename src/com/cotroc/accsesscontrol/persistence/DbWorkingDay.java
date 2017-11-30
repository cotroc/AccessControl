package com.cotroc.accsesscontrol.persistence;

import java.sql.Connection;
	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cotroc.accsesscontrol.blogic.DbResult;
import com.cotroc.accsesscontrol.model.WorkingDay;

public class DbWorkingDay {
	
	public static DbResult create(WorkingDay wday) {
		DbResult result;
		List<Object> list = new ArrayList<Object>();
		try {
		      String query = "insert into w_day (id_emp, id_place, punch_in) values (?, ?, ?)";
		      Connection conn;
		      conn = DbConn.getDataSource().getConnection();
		      PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		      preparedStmt.setInt(1, wday.getId_emp());
		      preparedStmt.setInt (2, wday.getId_place());
		      preparedStmt.setString(3, wday.getPunch_in());
		      preparedStmt.execute();
	          ResultSet generatedKeys = preparedStmt.getGeneratedKeys();
	          if (generatedKeys.next()) {
	        	  wday.setId((int)generatedKeys.getLong(1));
	        	  list.add(wday);
	        	  result = new DbResult(true, list, "Jornal creado: " + wday.getPunch_in());
	          } else {
	        	  wday = null;
	        	  result = new DbResult(false, null, null);
	          }
		      conn.close();
		} catch (SQLException e) {
			wday = null;
			list.add(wday);
			result = new DbResult(false, list, "No se pudo crear: " + e.getMessage());
		}
		return result;
	}
	
	public static DbResult update(WorkingDay wday) {
		DbResult result = null;
		try {
		      String query = "UPDATE w_day SET punch_out=? WHERE id=?";
		      Connection conn;
		      conn = DbConn.getDataSource().getConnection();
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, wday.getPunch_out());
		      preparedStmt.setInt(2, wday.getId());
		      preparedStmt.execute();
		      if(preparedStmt.executeUpdate() > 0) {
		    	  ArrayList<Object> wdayList = new ArrayList<Object>();
		    	  wdayList.add(wday);
		    	  result = new DbResult(true, wdayList, "Salida exitosa");
		      }
		      conn.close();
		} catch (SQLException e) {
			result = new DbResult(false, null, "Salida fallida: " + e.getMessage() );
			e.printStackTrace();
		}
		return result;
	}
	/*
	public static Dbresult findWdayById(WorkingDay wday) {
		List<Object> list = new ArrayList<Object>();
		DbResult result = null;
		WorkingDay wday = null;
		try {
			String query = "SELECT * FROM employee where ci=?";
		    Connection conn = DbConn.getDataSource().getConnection();
		    PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		    preparedStmt.setString(1, ci);
		    ResultSet rs = preparedStmt.executeQuery();
		    System.out.println(preparedStmt.toString());
		    while (rs.next()) {
			    wday = new Employee();
		    	wday.setId(rs.getInt("id"));
				wday.setName(rs.getString("name"));
				wday.setCi(rs.getString("ci"));
				wday.setAddress(rs.getString("address"));
				wday.setTel(rs.getString("tel"));
				wday.setAndroid_id(rs.getString("android_id"));
				list.add(wday);
		    }
			conn.close();
			preparedStmt.close();
			rs.close();
			if(list.size() > 0) {
				result = new DbResult(true, list, "Encontrado");
			} else {
				wday = new Employee();
				list.add(wday);
				result = new DbResult(false, list, "No existe Emp con ci: " + ci);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	*/
}
