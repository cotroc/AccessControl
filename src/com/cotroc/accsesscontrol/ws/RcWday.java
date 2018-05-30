package com.cotroc.accsesscontrol.ws;

import com.cotroc.accsesscontrol.blogic.BLWday;
import com.cotroc.accsesscontrol.model.Wday;

public class RcWday {
	
	public static ResponseWrapper saveWdayData(Wday wday) {
		return BLWday.wsSaveWdayData(wday);
	}
	
	/*
	public static ResponseWrapper getWdayList(WorkingDay wday) {
		return WorkingdayDao.wsGetWdayList(wday);
	}
	*/
}
