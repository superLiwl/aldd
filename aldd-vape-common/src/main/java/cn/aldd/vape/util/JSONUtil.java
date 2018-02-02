package cn.aldd.vape.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * All rights Reserved, Designed By 翼虎能源
 * Copyright:    Copyright(C) 2015-2017
 * Company   北京翼虎能源科技有限公司
 *
 * @author 李伟龙
 * @version 1.0
 * @date 2017年5月23日 下午1:52:21
 * @Description json工具类
 */
public class JSONUtil {

	private static Gson gson = null;

	static {
		gson = new Gson();//todo yyyy-MM-dd HH:mm:ss 
	}

	public static synchronized Gson newInstance() {
		if (gson == null) {
			gson = new Gson();
		}
		return gson;
	}

	/**
	 * toJson: Object转json
	 * @param obj 对象
	 * @return String json串
	 */
	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

	/**
	 * toBean: json转实体
	 * @param json  json串
	 * @param clz 实体
	 * @return T 实体
	 */
	public static <T> T toBean(String json, Class<T> clz) {
		return gson.fromJson(json, clz);
	}

	/**
	 * toMap: json转map
	 * @param json json串
	 * @param clz 类
	 * @return Map<String,T> json转换后的map
	 */
	public static <T> Map<String, T> toMap(String json, Class<T> clz) {
		Map<String, JsonObject> map = gson.fromJson(json, new TypeToken<Map<String, JsonObject>>() {
		}.getType());
		Map<String, T> result = new HashMap<>();
		for (String key : map.keySet()) {
			result.put(key, gson.fromJson(map.get(key), clz));
		}
		return result;
	}

	/**
	 * toMap: json转map
	 * @param json json串
	 * @return Map<String,Object> json转换后的map
	 */
	public static Map<String, Object> toMap(String json) {
		Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String, Object>>() {
		}.getType());
		return map;
	}

	/**
	 * toList: 转换成list
	 * @param json json串
	 * @param clz  类
	 * @return List<T> json转换后的list
	 */
	public static <T> List<T> toList(String json, Class<T> clz) {
		if(StringUtils.isBlank(json)){
			return null;
		}
		JsonArray array = new JsonParser().parse(json).getAsJsonArray();
		List<T> list = new ArrayList<>();
		for (final JsonElement elem : array) {
			list.add(gson.fromJson(elem, clz));
		}
		return list;
	}

}
