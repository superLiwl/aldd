package cn.aldd.vape.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

	/**
     * 获取本周的时间范围
     * @return 返回长度为2的字符串集合，如：[2017-10-30 00:00:00, 2017-11-05 24:00:00]
     */
    public static List<String> getCurrentWeekRange() {
        List<String> dataList = new ArrayList<String>(2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置周一为一周之内的第一天
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
        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置周一为一周之内的第一天
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
     * 获取今天是本周的第几天   周一--0   周日--6
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
     * @return 当前时间 yyyy-MM-dd
     */
    public static String dateFormat(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(null == date){
        	return dateFormat.format(new Date());
        }
        return dateFormat.format(date);
    }
    
}
