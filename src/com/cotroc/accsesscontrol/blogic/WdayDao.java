package com.cotroc.accsesscontrol.blogic;

import java.util.ArrayList;

import com.cotroc.accsesscontrol.dao.DbWday;
import com.cotroc.accsesscontrol.model.Wday;
import com.cotroc.accsesscontrol.ws.ResponseWrapper;

public class WdayDao {
	
	private static String sMessage = "Creado con exito";
	private static String noData = "Faltan datos";
	
	public static Wday saveWdayData(Wday wday) throws NoDataException {
		ArrayList<Wday> wdayList = DbWday.getWday(wday.getId_emp(), 
														wday.getPunch_in());
		Wday wdayRecorded = null;
		
		if(wdayList.isEmpty()) {
			wdayRecorded = create(wday);
			System.out.println("funciono");
		} /*else if(wdayList.get(0) ) {
			
		} else {
			
		}
		
		/*
		if(checkForNull(wday.getId_emp(), wday.getId_place(),
				wday.getPunch_in())) {
			throw new NoDataException(noData);
		} 
		
		if(checkForNull(wday.getPunch_out())) {
			wdayRecorded = create(wday);
		} else {
			wdayRecorded = update(wday);
		}
		
		*/
		
		return wdayRecorded;
	}
	
	private static Wday create(Wday wday) {
		return DbWday.create(wday);
	}
	
	private static Wday update(Wday wday){
		return DbWday.update(wday);
	}
	
	/*
	public static ResponseWrapper wsGetWdayList(WorkingDay wday) {
		ArrayList<WorkingDay> wdayList = null;
		boolean success = false;
		String message = null;
		
		try {
			wdayList = getWdayList(wday);
			success = true;
			message = sMessage;
		} catch(NoDataException e) {
			message = e.getMessage();
			success = false;
		}
		return new ResponseWrapper(success, message, wdayList);
	}
	*/
	
	private static ArrayList<Wday> getWdayList(Wday wday) throws NoDataException {
		if(checkForNull(wday.getId_emp(), wday.getPunch_in()))
			throw new NoDataException(noData);
		return DbWday.getWday(wday.getId_emp(), wday.getPunch_in());
	}
	
	public static ResponseWrapper wsSaveWdayData(Wday wday) {
		Wday createdWday = null;
		boolean success = false;
		String message = null;
		try {
			createdWday = saveWdayData(wday);
			success = true;
			message = sMessage;
		} catch(NoDataException e) {
				message = e.getMessage();
				success = false;
		}
		return new ResponseWrapper(success, message, createdWday);
	}
	/*
	public static ResponseWrapper getWday(int id_emp, String date) {
		boolean success = false;
		ArrayList<WorkingDay> wdayList = null;
		String message = null;
		try {
			wdayList = WorkingdayDao.getWday(id_emp, date);
			success = true;
			message = "Creado con exito";
		} catch(NoDataException e) {
			message = e.getMessage();
			success = false;
		}
		return new ResponseWrapper(success, message, wdayList);
	}
	*/
	private static boolean checkForNull(Object... objects) {
		boolean isNull = false;
		for(Object o : objects) {
			System.out.println("for -->> " + o.toString());
			if(o == null || o.equals("")) {
				isNull = true;
			}
		}
		return isNull;
	}
}
