package com.cotroc.accsesscontrol.blogic;

import java.util.ArrayList;

import com.cotroc.accsesscontrol.model.PlaceDAO;
import com.cotroc.accsesscontrol.model.Place;

public class BLPlace {

	public static ArrayList<Place> getAllPlaces() {
		return PlaceDAO.getAllPlaces();
	}
}
