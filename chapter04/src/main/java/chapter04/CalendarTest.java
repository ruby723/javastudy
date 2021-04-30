package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
		printDate(cal);
		
		cal.set(Calendar.YEAR,2020);
		cal.set(Calendar.MONTH,11); //-1해서 세팅해야함   11=12월
		cal.set(Calendar.DATE,25);
		printDate(cal);
		
		cal.set(2010,10,10);
		cal.add(Calendar.DATE,1000);
		printDate(cal);
	}
	
	private static void printDate(Calendar cal) {
		final String[] DAYS= {"일","월","화","수","목","금","토"};
		
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH);
		int date=cal.get(Calendar.DATE);
		int day=cal.get(Calendar.DAY_OF_WEEK);// 요일 1(일)-7(토)
		int hour=cal.get(Calendar.HOUR);
		int minute=cal.get(Calendar.MINUTE);
		int second=cal.get(Calendar.SECOND);
		
		System.out.println(
				year  +"년"+ (month+1)+"월"+
				date+"일"+DAYS[day-1]+"요일  "+
				hour+"시 "+minute+"분 "+second+"초");
		
	}

}
