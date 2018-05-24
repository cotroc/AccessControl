package com.cotroc.accsesscontrol.dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbConn {
	
	private static DataSource dataSource = null;
	
	public static DataSource getDataSource() {
		
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/" + "jdbc/TestDB");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataSource;
	}
}
