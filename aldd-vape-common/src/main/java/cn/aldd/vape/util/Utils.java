package cn.aldd.vape.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Utils {
	/**
	 * 获取UUID
	 * @return uuid
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * isNullList: 判断list是否为空
	 * @param list 判断是否为空的list
	 * @return boolean 空 返回 true ，不为空返回false
	 */
	public static boolean isNullList(List<?> list) {
		if (null == list || list.isEmpty() || list.size() == ParamConstans.NUM_ZERO.intValue()) {
			return true;
		}
		return false;
	}
	
	/**
	 * isInList: 判断字符串是否在list中
	 */
	public static boolean isInList(List<String> list , String str) {
		for(String s : list){
			if(s.equals(str)){
				return true;
			}
		}
		return false;
	}

	/**
	 * isNullStrArry: 判断字符串数组是否为空
	 * @param arry  字符串数组
	 * @return boolean 空 返回 true ，不为空返回false
	 */
	public static boolean isNullStrArry(String[] arry) {
		if (null == arry || arry.length == ParamConstans.NUM_ZERO.intValue()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 生成随机数
	 * @return 随机数
	 */
	public static int getRandomNum(int num) {
		Random ran = new Random();
		int result = ran.nextInt(num);
		if(result > 4){
			result = ran.nextInt(num);
		}
		return result;
	}
	
	/**
	 * 字符串加法
	 * @return 随机数
	 */
	public static String add(String v1, String v2) {  
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);  
        return b1.add(b2).toString();  
    }  
	
	/**
	 * 转utf8
	 */
	public static String strToUTF(String str) {
		return str;
//		if (null == str || "".equals(str)) {
//			return "";
//		}
//		try {
//			str = new String(str.getBytes(), "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return str;
	}

}
