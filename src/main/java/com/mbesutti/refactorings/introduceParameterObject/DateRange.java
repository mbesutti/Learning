package com.mbesutti.refactorings.introduceParameterObject;

import java.util.Date;

public class DateRange {

	public DateRange(Date start, Date end) {
		this.start = start;
		this.end = end;
	}
	public boolean includes(Date date) {
		return	 (date.equals(start) ||
		                date.equals(end) ||
		                 (date.after(start) && date.before(end)));
	}
	public Date start;
	public Date end;

}
