package cn.aldd.vape.user.micro.constants;

import java.util.HashMap;
import java.util.Map;

public enum DynamicTypeEnum {

	REWARD("reward", "点赞"), 
	FABULOUS("fabulous", "打赏"), 
	COMMENT("comment", "评论");

	private String key;
	private String value;

	private DynamicTypeEnum(String key, String value) {
		this.setKey(key);
		this.setValue(value);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static Map<String, String> getMap() {
		Map<String, String> map = new HashMap<String, String>();
		for (DynamicTypeEnum enums : DynamicTypeEnum.values()) {
			map.put(enums.getKey(), enums.getValue());
		}
		return map;
	}
}
