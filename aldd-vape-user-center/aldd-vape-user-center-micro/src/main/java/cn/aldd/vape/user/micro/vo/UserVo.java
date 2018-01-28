package cn.aldd.vape.user.micro.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.aldd.vape.common.Page;
import io.swagger.annotations.ApiModelProperty;

public class UserVo extends Page {

	private static final long serialVersionUID = 1L;
	
	
	@ApiModelProperty(value = "主键id")
	private String id;
	
	
	@ApiModelProperty(value = "")
	private String openId;
	
	
	@ApiModelProperty(value = "地址")
	private String address;
	
	
	@ApiModelProperty(value = "年龄")
	private String age;
	
	
	@ApiModelProperty(value = "编号")
	private String code;
	
	
	@ApiModelProperty(value = "性别")
	private String gender;
	
	
	@ApiModelProperty(value = "头像")
	private String headPortraitImg;
	
	
	@ApiModelProperty(value = "爱好")
	private String hobby;
	
	
	@ApiModelProperty(value = "登录名")
	private String loginName;
	
	
	@ApiModelProperty(value = "昵称")
	private String nickName;
	
	
	@ApiModelProperty(value = "密码")
	private String password;
	
	
	@ApiModelProperty(value = "口粮")
	private String ration;
	
	
	@ApiModelProperty(value = "标签")
	private String signature;
	
	
	@ApiModelProperty(value = "技能")
	private String skill;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@ApiModelProperty(value = "创建时间")
	private java.util.Date createTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@ApiModelProperty(value = "更新时间")
	private java.util.Date updateTime;
	

// setter and getter
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getOpenId(){
		return openId;
	}
	
	public void setOpenId(String openId){
		this.openId = openId;
	}
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	public String getAge(){
		return age;
	}
	
	public void setAge(String age){
		this.age = age;
	}
	public String getCode(){
		return code;
	}
	
	public void setCode(String code){
		this.code = code;
	}
	public String getGender(){
		return gender;
	}
	
	public void setGender(String gender){
		this.gender = gender;
	}
	public String getHeadPortraitImg(){
		return headPortraitImg;
	}
	
	public void setHeadPortraitImg(String headPortraitImg){
		this.headPortraitImg = headPortraitImg;
	}
	public String getHobby(){
		return hobby;
	}
	
	public void setHobby(String hobby){
		this.hobby = hobby;
	}
	public String getLoginName(){
		return loginName;
	}
	
	public void setLoginName(String loginName){
		this.loginName = loginName;
	}
	public String getNickName(){
		return nickName;
	}
	
	public void setNickName(String nickName){
		this.nickName = nickName;
	}
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	public String getRation(){
		return ration;
	}
	
	public void setRation(String ration){
		this.ration = ration;
	}
	public String getSignature(){
		return signature;
	}
	
	public void setSignature(String signature){
		this.signature = signature;
	}
	public String getSkill(){
		return skill;
	}
	
	public void setSkill(String skill){
		this.skill = skill;
	}
	public java.util.Date getCreateTime(){
		return createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	public java.util.Date getUpdateTime(){
		return updateTime;
	}
	
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	
}