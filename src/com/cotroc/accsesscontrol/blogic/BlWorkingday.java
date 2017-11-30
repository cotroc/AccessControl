package com.cotroc.accsesscontrol.blogic;

import com.cotroc.accsesscontrol.model.WorkingDay;
import com.cotroc.accsesscontrol.persistence.DbWorkingDay;

public class BlWorkingday {
	
	public static DbResult create(WorkingDay wday) {
		return DbWorkingDay.create(wday);
	}
	
	public static DbResult update(WorkingDay wday) {
		return DbWorkingDay.update(wday);
	}
}
