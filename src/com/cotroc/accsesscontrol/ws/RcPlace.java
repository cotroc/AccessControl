package com.cotroc.accsesscontrol.ws;

import com.cotroc.accsesscontrol.blogic.DbResult;
import com.cotroc.accsesscontrol.blogic.BlPlace;

public class RcPlace {
	
	public static ResponseWrapper getAllPlaces() {
		DbResult empList = BlPlace.getAllPlaces();
		return new ResponseWrapper(empList.isSuccsess(),
									empList.getMessage(),
									empList.getObjects());
	}
	
}
