package com.youfan.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String dateToString(Date date) {
		// TODO Auto-generated method stub
		return dateToString(date,"yyyy=MM-dd hh:mm:ss:SSS");
	}

	public static String dateToString(Date date, String formatstring) {
		DateFormat dateFormat = new SimpleDateFormat(formatstring);
		return dateFormat.format(date);
	}

}
