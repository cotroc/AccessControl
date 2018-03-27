package com.cotroc.accsesscontrol.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cotroc.accsesscontrol.model.Place;

public class DbPlace {

	public static ArrayList<Place> getAllPlaces() {
		ArrayList<Place> placeList = new ArrayList();
		Place place = null;
		try {
			Connection conn = DbConn.getDataSource().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM place");
			while (rs.next()) {
				System.out.println("Latitud: " + rs.getDouble("lat") + " Longitud: " + rs.getDouble("lon"));
					place = new Place();
					place.setId(rs.getInt("id"));
					place.setId_cli(rs.getInt("id_cli"));
					place.setName(rs.getString("name"));
					place.setLat(rs.getDouble("lat"));
					place.setLon(rs.getDouble("lon"));
					placeList.add(place);
			}
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			place = null;
		}
		return placeList;
	}
}
