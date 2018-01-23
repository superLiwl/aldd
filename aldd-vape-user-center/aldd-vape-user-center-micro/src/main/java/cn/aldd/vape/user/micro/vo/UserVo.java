package cn.aldd.vape.user.micro.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.aldd.vape.common.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户")
public class UserVo extends Page {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "登录名")
	private String loginName;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	@ApiModelProperty(value = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date updateTime;

	@ApiModelProperty(value = "头像")
	private String headPortraitImg;

	@ApiModelProperty(value = "昵称")
	private String nickName;

	@ApiModelProperty(value = "性别")
	private String gender;

	@ApiModelProperty(value = "地址")
	private String address;

	@ApiModelProperty(value = "地址")
	private String age;

	@ApiModelProperty(value = "代号")
	private String code;

	@ApiModelProperty(value = "技能")
	private String skill;

	@ApiModelProperty(value = "爱好")
	private String hobby;

	@ApiModelProperty(value = "个人签名")
	private String signature;

	@ApiModelProperty(value = "我的口粮")
	private String ration;

	@ApiModelProperty(value = "我的设备")
	private String equipment;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getHeadPortraitImg() {
		return headPortraitImg;
	}

	public void setHeadPortraitImg(String headPortraitImg) {
		this.headPortraitImg = headPortraitImg;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getRation() {
		return ration;
	}

	public void setRation(String ration) {
		this.ration = ration;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

}