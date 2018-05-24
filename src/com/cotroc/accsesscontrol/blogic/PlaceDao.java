package com.cotroc.accsesscontrol.blogic;

import java.util.ArrayList;

import com.cotroc.accsesscontrol.dao.DbPlace;
import com.cotroc.accsesscontrol.model.Place;

public class PlaceDao {

	public static ArrayList<Place> getAllPlaces() {
		return DbPlace.getAllPlaces();
	}
}
