package cn.aldd.vape.user.micro.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class WxUserLoginVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "wx的openId")
	private String openId;
	@ApiModelProperty(value = "地址")
	private String address;
	@ApiModelProperty(value = "经度")
	private String longitude;
	@ApiModelProperty(value = "纬度")
	private String latitude;
	@ApiModelProperty(value = "昵称")
	private String nickName;
	@ApiModelProperty(value = "头像")
	private String headPortraitImg;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadPortraitImg() {
		return headPortraitImg;
	}

	public void setHeadPortraitImg(String headPortraitImg) {
		this.headPortraitImg = headPortraitImg;
	}

}