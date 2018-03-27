package com.cotroc.accsesscontrol.blogic;

import java.util.ArrayList;

import com.cotroc.accsesscontrol.model.Place;
import com.cotroc.accsesscontrol.persistence.DbPlace;

public class PlaceDao {

	public static ArrayList<Place> getAllPlaces() {
		return DbPlace.getAllPlaces();
	}
}
