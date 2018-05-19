package com.youfan.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String transferdate(Date date,String dateFormatparam){
		DateFormat dateFormat = new SimpleDateFormat(dateFormatparam);
		return dateFormat.format(date);
		
	}
	
	public static Date transferdate(String datastring,String dateFormatparam){
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat(dateFormatparam);
		try {
			date = dateFormat.parse(datastring);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
		
	}
}
