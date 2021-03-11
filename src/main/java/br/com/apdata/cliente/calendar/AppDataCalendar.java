package br.com.apdata.cliente.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AppDataCalendar {

	public static int returnDayOfWeek() {	
		return new GregorianCalendar().get(Calendar.DAY_OF_WEEK);
	}
}
