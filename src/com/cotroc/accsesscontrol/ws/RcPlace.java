package com.cotroc.accsesscontrol.ws;

import com.cotroc.accsesscontrol.blogic.BLPlace;

public class RcPlace {
	
	public static ResponseWrapper getAllPlaces() {
		return new ResponseWrapper(true, "Lista de Obras", BLPlace.getAllPlaces());
	}
	
}
