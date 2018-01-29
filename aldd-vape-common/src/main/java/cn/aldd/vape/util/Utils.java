package cn.aldd.vape.util;

import java.util.List;
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
}
