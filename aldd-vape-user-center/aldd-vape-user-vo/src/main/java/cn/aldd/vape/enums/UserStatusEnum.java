package cn.aldd.vape.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserStatusEnum {

	NORMAL("normal", "正常"), FROZEN("frozen", "冻结");

	private String key;
	private String value;

	private UserStatusEnum(String key, String value) {
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
		for (UserStatusEnum enums : UserStatusEnum.values()) {
			map.put(enums.getKey(), enums.getValue());
		}
		return map;
	}
}
