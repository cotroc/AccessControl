package com.cotroc.accsesscontrol.blogic;

import com.cotroc.accsesscontrol.persistence.DbPlace;

public class BlPlace {

	public static DbResult getAllPlaces() {
		return DbPlace.getAllPlaces();
	}
}
