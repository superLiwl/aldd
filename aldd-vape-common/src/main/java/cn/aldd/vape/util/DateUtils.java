package cn.aldd.vape.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateUtils {

	/**
	 * 获取本周的时间范围
	 * 
	 * @return 返回长度为2的字符串集合，如：[2017-10-30 00:00:00, 2017-11-05 24:00:00]
	 */
	public static List<String> getCurrentWeekRange() {
		List<String> dataList = new ArrayList<String>(2);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);// 设置周一为一周之内的第一天
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String monday = dateFormat.format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String sunday = dateFormat.format(calendar.getTime());
		dataList.add(monday);
		dataList.add(sunday);
		return dataList;
	}

	/**
	 * 获取本周的日期集合 yyyy-MM-dd
	 */
	public static List<String> getCurrentWeekDays() {
		List<String> dataList = new ArrayList<String>(2);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);// 设置周一为一周之内的第一天
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String monday = dateFormat.format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		String tues = dateFormat.format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		String wed = dateFormat.format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		String thur = dateFormat.format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		String fri = dateFormat.format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		String sat = dateFormat.format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String sunday = dateFormat.format(calendar.getTime());
		dataList.add(monday);
		dataList.add(tues);
		dataList.add(wed);
		dataList.add(thur);
		dataList.add(fri);
		dataList.add(sat);
		dataList.add(sunday);
		return dataList;
	}

	/**
	 * 获取今天是本周的第几天 周一--0 周日--6
	 */
	public static int getNumDayOfWeek() {
		Calendar c = Calendar.getInstance();
		int num = c.get(Calendar.DAY_OF_WEEK);
		if (num == 1) {
			num = 7;
		} else {
			num--;
		}
		num--;
		return num;
	}

	/**
	 * 将Date转字符串 yyyy-MM-dd
	 * 
	 * @return 当前时间 yyyy-MM-dd
	 */
	public static String dateFormat(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (null == date) {
			return dateFormat.format(new Date());
		}
		return dateFormat.format(date);
	}

	/**
	 * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * dateToYmdHms: Date转换成String  yyyy-MM-dd HH:mm:ss
	 * @param date 选定的日期
	 * @return String yyyy-MM-dd HH:mm:ss  格式的字符串
	 */
	public static String dateToYmdHms(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		return str;
	}
	
	/**
	 * longToYmdHms: 毫秒转换成String  yyyy-MM-dd HH:mm:ss
	 * @param time 毫秒
	 * @return String yyyy-MM-dd HH:mm:ss  格式的字符串
	 */
	public static String longToYmdHms(Long time) {
		if (null == time) {
			return "";
		}
		Date date = new Date(time);
		return dateToYmdHms(date);
	}
	
	/**
	 * dateAddDays: 日期加上几天
	 * @param date 日期
	 * @param count 加上几天
	 * @return Date
	 */
	public static Date dateAddDays(Date date, int count) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, count);
		return calendar.getTime();
	}
	
	/**
	 * dateAddDays: 日期加上1天
	 * @param date 日期
	 * @return Date
	 */
	public static Date dateAddDay(String time) {
		Date date = strToDate(time);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	/**
	 * dateAddMonth: 日期加上几个月
	 * @param date 日期
	 * @param count 加上几个月
	 * @return Date
	 */
	public static Date dateAddMonth(Date date, int count) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, count);
		return dateAddDays(calendar.getTime(), -1);
	}
	
	/**
	 * strToYmdHms: 将字符串转换成Date格式  "yyyy-MM-dd HH:mm:ss"
	 * @param dstr "yyyy-MM-dd HH:mm:ss"时间
	 * @return Date Date格式   "yyyy-MM-dd HH:mm:ss"
	 */
	public static Date strToYmdHms(String dstr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(dstr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * dateSubtractDay: 日期减去一天
	 */
	public static Date dateSubtractDay(String time) {
		Date date = strToYmdHms(longToYmdHms(Long.parseLong(time)));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}
	
	/**
	 * getStartAndEndTime: 获取排行榜开始结束时间
	 */
	public static String[] getStartAndEndTime(){
		String arry[] = new String[2];
		Date now = new Date();
		String toDaySix = DateUtils.dateFormat(now) + " 06:00:00";
		Date six = strToDate(toDaySix);
		if(now.before(six)){
			arry[0] = dateToYmdHms(dateSubtractDay(toDaySix));
			arry[1] = toDaySix;
		}else{
			arry[0] = toDaySix;
			arry[1] = dateToYmdHms(dateAddDay(toDaySix));
		}
		return arry;
	}
	
	/**
	 * 将Date转字符串
	 */
	public static String dateFormat(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		if (null == date) {
			return dateFormat.format(new Date());
		}
		return dateFormat.format(date);
	}

}
