package cn.aldd.vape.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * All rights Reserved, Designed By 翼虎能源
 * Copyright:    Copyright(C) 2015-2017
 * Company   北京翼虎能源科技有限公司
 *
 * @author 严作宇
 * @version 1.0
 * @date 2017年3月31日 下午12:18:57
 * @Description 分页信息验证工具类
 */
public class ParamUtils {
	/**
	 * 判断分页参数是否正确
	 * @param params
	 * @return
	 */
	public static int checkPageParam(Map<String, Object> params) {
		if (params.containsKey("pageNum") && params.containsKey("pageSize")) {
			String page = String.valueOf(params.get("pageNum"));
			String pagesize = String.valueOf(params.get("pageSize"));
			if (StringUtils.isNumeric(page) && StringUtils.isNumeric(pagesize)) {
				return ParamConstans.SUCCESS;
			} else {
				return ParamConstans.FAIL;
			}
		}
		return ParamConstans.NOMAL;
	}

	/**
	 * 用来 验证和转换排序参数 将驼峰字段转换成数据库字段
	 * @param object
	 * @param sorts
	 * @return
	 */
	public static Map<Integer, Object> convertSortParam(Object object, String sorts) {
		Map<Integer, Object> result = new HashMap<Integer, Object>();
		//将排序参数 转换为 object.sort 规定所属对象
		StringBuilder convertString = new StringBuilder();
		String objectName = convertName(object.getClass().getSimpleName());
		String[] sor = sorts.split(",");
		if (sor.length == 0) {
			result.put(ParamConstans.FAIL, "参数错误");
			return result;
		}
		int count = 0;//计数器
		for (String s : sor) {
			count++;
			if (!ObjectReflect.Contains(object, s.split(" ")[0])) {
				result.put(ParamConstans.FAIL, "参数错误" + s.split(" ")[0]);
				return result;
			} else {
				convertString.append(objectName).append(".");
				convertString.append(Underline2Camel.camel2Underline(s.split(" ")[0]));
			}
			if (s.split(" ").length > 1) {
				if (s.split(" ")[1].compareToIgnoreCase("asc") < 0 && s.split(" ")[1].compareToIgnoreCase("desc") < 0) {
					result.put(ParamConstans.FAIL, "参数错误" + s.split(" ")[1]);
					return result;
				} else {
					convertString.append(" ");
					convertString.append(s.split(" ")[1]);
				}
			}
			if (count != sor.length) {
				convertString.append(",");
			}

		}
		result.put(ParamConstans.SUCCESS, convertString.toString());
		return result;
	}

	public static String convertName(String name) {
		name = name.substring(0, 1).toLowerCase() + name.substring(1);
		return name;
	}

	/**
	 * isNullList: 判断list是否为空
	 * @param list 判断是否为空的list
	 * @return boolean 空 返回 true  ，不为空返回false
	 */
	public static boolean isNullList(List<?> list) {
		if (null == list || list.isEmpty() || list.size() == ParamConstans.NUM_ZERO.intValue()) {
			return true;
		}
		return false;
	}


	/**
	 * isNullStrArry: 判断字符串数组是否为空
	 * @param arry 字符串数组
	 * @return boolean 空 返回 true  ，不为空返回false
	 */
	public static boolean isNullStrArry(String[] arry) {
		if (null == arry || arry.length == ParamConstans.NUM_ZERO.intValue()) {
			return true;
		}
		return false;
	}

}
