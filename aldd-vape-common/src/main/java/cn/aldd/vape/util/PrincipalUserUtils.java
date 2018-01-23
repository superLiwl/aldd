package cn.aldd.vape.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * All rights Reserved, Designed By 翼虎能源
 * Copyright:    Copyright(C) 2015-2017
 * Company   北京翼虎能源科技有限公司
 *
 * @author 李伟龙
 * @version 1.0
 * @date 2017年4月18日 上午11:43:17
 * @Description 登录用户工具类
 */
public class PrincipalUserUtils {

	/**
	 * getPersonId: 获取登录用户的personId
	 * @param user 用户字符串
	 * @return String 登录用户的personId
	 */
	public static String getPersonId(String user) {
		return getUserJsonInfo(user).get(ParamConstans.USER_AUTH_PERSON_ID).toString();
	}

	/**
	 * getPersonId: 获取登录用户的userId
	 * @param user 用户字符串
	 * @return String 登录用户的userId
	 */

	public static String getUserId(String user) {
		return getUserJsonInfo(user).get(ParamConstans.USER_AUTH_USER_ID).toString();
	}
	/**
	 * getOrgList: 获取组织json数组（多个）
	 * @param user 用户字符串
	 * @return JSONArray 组织json数组
	 */
	public static JSONArray getOrgJsonArray(String user) {
		return getJsonArryList(getUserJsonInfo(user), ParamConstans.USER_AUTH_ORGS);
	}

	/**
	 * getSiteList: 获取站点json数组（多个）
	 * @param user 用户字符串
	 * @return JSONArray 站点json数组
	 */
	public static JSONArray getSiteJsonArray(String user) {
		return getJsonArryList(getUserJsonInfo(user), ParamConstans.USER_AUTH_SITES);
	}

	/**
	 * getOrgIdByUser: 获取组织id(一个)
	 * @param user 登录用户
	 * @return String 组织id
	 */
	public static String getOrgIdByUser(String user) {
		String orgId = null;
		JSONArray orgArry = getOrgJsonArray(user);
		if (null != orgArry && !orgArry.isEmpty() && orgArry.size() > ParamConstans.NUM_ZERO.intValue()) {
			orgId = JSONObject.parseObject(orgArry.get(ParamConstans.NUM_ZERO).toString())
					.get(ParamConstans.USER_AUTH_ID).toString();
		}
		return orgId;
	}

	/**
	 * getSiteIdByUser: 获取站点id(一个)
	 * @param user 登录用户
	 * @return String 站点id
	 */
	public static String getSiteIdByUser(String user) {
		String siteId = null;
		JSONArray siteArry = getSiteJsonArray(user);
		if (null != siteArry && !siteArry.isEmpty() && siteArry.size() > ParamConstans.NUM_ZERO.intValue()) {
			siteId = JSONObject.parseObject(siteArry.get(ParamConstans.NUM_ZERO).toString())
					.get(ParamConstans.USER_AUTH_ID).toString();
		}
		return siteId;
	}

	/**
	 * getUserJsonInfo: 获取用户json串
	 * @param user 用户字符串
	 * @return JSONObject 用户json串
	 */
	private static JSONObject getUserJsonInfo(String user) {
		JSONObject jsonObj = JSONObject.parseObject(user);
		jsonObj = JSONObject.parseObject(jsonObj.get(ParamConstans.USER_AUTH).toString());
		jsonObj = JSONObject.parseObject(jsonObj.get(ParamConstans.USER_AUTH_DETAILS).toString());
		jsonObj = JSONObject.parseObject(jsonObj.get(ParamConstans.USER_AUTH).toString());
		jsonObj = JSONObject.parseObject(jsonObj.get(ParamConstans.USER_AUTH_PRINCIPAL).toString());
		return jsonObj;
	}

	/**
	 * getJsonArryList: 获取json数组
	 * @param jsonObj json串
	 * @param code 节点标识
	 * @return JSONArray json数组
	 */
	private static JSONArray getJsonArryList(JSONObject jsonObj, String code) {
		JSONArray orgArry = null;
		if (null != jsonObj.get(code)) {
			orgArry = JSONArray.parseArray(jsonObj.get(code).toString());
		}
		return orgArry;
	}
}
