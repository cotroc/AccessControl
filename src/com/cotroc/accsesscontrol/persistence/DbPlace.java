package com.cotroc.accsesscontrol.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cotroc.accsesscontrol.blogic.DbResult;
import com.cotroc.accsesscontrol.model.Place;

public class DbPlace {

	public static DbResult getAllPlaces() {
		DbResult result = null;
		List<Object> list = new ArrayList<Object>();
		try {
			Connection conn = DbConn.getDataSource().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM place");
			while (rs.next()) {
				System.out.println("Latitud: " + rs.getDouble("lat") + " Longitud: " + rs.getDouble("lon"));
					Place place = new Place();
					place.setId(rs.getInt("id"));
					place.setId_cli(rs.getInt("id_cli"));
					place.setName(rs.getString("name"));
					place.setLat(rs.getDouble("lat"));
					place.setLon(rs.getDouble("lon"));
					
					list.add(place);
			}
			result = new DbResult(true, list, "Lista de obras");
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
