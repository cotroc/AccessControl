package com.cotroc.accsesscontrol.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.cotroc.accsesscontrol.model.Wday;

public class DbWday {
	
	private static String dateFormat = "yyyy-MM-dd HH:mm:ss";

	public static Wday create(Wday wday) {
		try {
	      String query = "insert into w_day (id_emp, id_place, punch_in) values (?, ?, ?)";
	      Connection conn;
	      conn = DbConn.getDataSource().getConnection();
	      PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	      preparedStmt.setInt(1, wday.getId_emp());
	      preparedStmt.setInt (2, wday.getId_place());
	      preparedStmt.setString(3, dateToString(wday.getPunch_in(), dateFormat));
	      preparedStmt.execute();
	      ResultSet generatedKeys = preparedStmt.getGeneratedKeys();
	      if (generatedKeys.next())
	    	  wday.setId((int)generatedKeys.getLong(1));
	      conn.close();
		} catch (SQLException e) {
			cLog("catch " + e);
			wday = null;
		}
		cLog("DbWday-->> returned wday " + wday);
		return wday;
	}
	
	public static Wday update(Wday wday) {
		
		try {
		      String query = "UPDATE w_day SET punch_out=? WHERE id=?";
		      Connection conn;
		      conn = DbConn.getDataSource().getConnection();
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setDate (1, (java.sql.Date) wday.getPunch_out());
		      preparedStmt.setInt(2, wday.getId());
		      preparedStmt.execute();
		      if(preparedStmt.executeUpdate() > 0) {
		    	  return wday;
		      }
		      conn.close();
		} catch (SQLException e) {
			wday = null;
		}
		return wday;
	}
	
public static ArrayList<Wday> getWday(int id_emp, Date date) {
		ArrayList<Wday> wdayList = new ArrayList<>();
		Connection conn;
		PreparedStatement preparedStmt;
		ResultSet rs;

		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 00);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		Date dateFrom = cal.getTime();
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		Date dateTo = cal.getTime();
		
		try {
	      String query = "SELECT * FROM `w_day` JOIN employee " +
    		    "			ON w_day.id_emp = employee.id" + 
      			"			WHERE punch_in >=?" + // dateFrom
	      		"			AND punch_in <=?" + // dateTo
	      		"			AND employee.id =?" +
	      		"			ORDER BY punch_in DESC";
	      conn = DbConn.getDataSource().getConnection();
	      preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, dateToString(dateFrom, dateFormat));
	      preparedStmt.setString (2, dateToString(dateTo, dateFormat));
	      preparedStmt.setInt(3, id_emp);
	      rs = preparedStmt.executeQuery();
	      while (rs.next()) {
	    	  Date p_in = stringToDate(rs.getString("punch_in"), dateFormat);
	    	  Date p_out = stringToDate(rs.getString("punch_out"), dateFormat);

	  		  Wday wday = new Wday();
	    	  wday.setId(rs.getInt("id"));
	    	  wday.setId_emp(rs.getInt("id_emp"));
	    	  wday.setId_place(rs.getInt("id_place"));
	    	  wday.setPunch_in(p_in);
	    	  wday.setPunch_out(p_out);
	    	  wdayList.add(wday);
	      }
	    	  
	      rs.close();	  
	      conn.close();
		} catch (SQLException e) {
			cLog("catch " + e.getMessage());
			wdayList = null;
		} catch (Exception d) {
			//cLog("Exception " + d.getMessage());
		}
		return wdayList;
	}

	private static String dateToString(Date date, String stringFormat) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(stringFormat);
		cLog("Date to String >> " + date);
		return sdf.format(date);
	}
	
	private static Date stringToDate(String dateString, String stringFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(stringFormat);
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			cLog("DbWday dateToString --> " + e.toString());
			e.printStackTrace();
		}
		cLog("String to Date >> " + date);

		return date;
	}
	
	private static void cLog(String message) {
		System.out.println(message);
	}
}
