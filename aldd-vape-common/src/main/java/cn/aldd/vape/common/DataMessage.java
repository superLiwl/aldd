package cn.aldd.vape.common;

import com.netflix.hystrix.exception.HystrixRuntimeException;

public class DataMessage {
	private boolean success;

	private String msg;

	private String detailMsg;

	private Object data;

	private String errorCode;

	public static DataMessage create(String msg, String errorCode, String detailMsg, boolean success, Object data) {
		DataMessage dataMesage = new DataMessage();
		dataMesage.setMsg(msg);
		dataMesage.setErrorCode(errorCode);
		dataMesage.setDetailMsg(detailMsg);
		dataMesage.setSuccess(success);
		dataMesage.setData(data);
		return dataMesage;
	}

	public static DataMessage createSuccessMsg(Object data, String msg, String detailMsg) {
		DataMessage dataMesage = new DataMessage();
		dataMesage.setMsg(msg);
		dataMesage.setDetailMsg(detailMsg);
		dataMesage.setData(data);
		dataMesage.setSuccess(true);
		return dataMesage;
	}

	public static DataMessage createErrorMsg(String errorCode, String msg, String detailMsg) {
		DataMessage dataMesage = new DataMessage();
		dataMesage.setErrorCode(errorCode);
		dataMesage.setMsg(msg);
		dataMesage.setDetailMsg(detailMsg);
		dataMesage.setSuccess(false);
		return dataMesage;
	}

	public static DataMessage createErrorMsg(String errorCode, Exception e) {
		DataMessage dataMesage = new DataMessage();
		dataMesage.setErrorCode(errorCode);
		dataMesage.setSuccess(false);
		String msg;
		if (e instanceof HystrixRuntimeException) {
			msg = ((HystrixRuntimeException) e).getFallbackException().getMessage();
		} else {
			msg = e.getMessage();
		}
		dataMesage.setMsg(msg);
		dataMesage.setDetailMsg(msg);
		return dataMesage;
	}

	public DataMessage() {
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDetailMsg() {
		return this.detailMsg;
	}

	public void setDetailMsg(String detailMsg) {
		this.detailMsg = detailMsg;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DataMessage [success=" + success + ", msg=" + msg + ", detailMsg=" + detailMsg + ", data=" + data
				+ ", errorCode=" + errorCode + "]";
	}

}
