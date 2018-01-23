package cn.aldd.vape.util;

import java.lang.reflect.Field;
/**
 * All rights Reserved, Designed By 翼虎能源
 * Copyright:    Copyright(C) 2015-2017
 * Company   北京翼虎能源科技有限公司
 *
 * @author 严作宇
 * @version 1.0
 * @date 2017年3月31日 下午12:18:14
 * @Description 对象反射工具类
 */
public class ObjectReflect {
	
	public static boolean Contains(Object o ,String name){
		Field[] fileds = o.getClass().getDeclaredFields() ;
		for (Field field : fileds) {
			if(field.getName().equals(name)){
				return true; 
			}
		}
		return false ;
	}
	
}
