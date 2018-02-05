package cn.aldd.vape.user.micro.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class DynamicInfosVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "评论")
	private String commentId;
	@ApiModelProperty(value = "业务id")
	private String businessId;
	@ApiModelProperty(value = "业务数据")
	private String businessData;
	@ApiModelProperty(value = "动态id")
	private String dynamicId;
	@ApiModelProperty(value = "业务类型")
	private String type;
	@ApiModelProperty(value = "业务创建人昵称")
	private String nickName;
	@ApiModelProperty(value = "业务创建人头像")
	private String headPortraitImg;
	@ApiModelProperty(value = "业务创建人id")
	private String createUserId;
	@ApiModelProperty(value = "动态发表人id")
	private String createDyUser;
	@ApiModelProperty(value = "动态发表人头像")
	private String createDyUserImg;
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date createTime;

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

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getBusinessData() {
		return businessData;
	}

	public void setBusinessData(String businessData) {
		this.businessData = businessData;
	}

	public String getDynamicId() {
		return dynamicId;
	}

	public void setDynamicId(String dynamicId) {
		this.dynamicId = dynamicId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCreateDyUser() {
		return createDyUser;
	}

	public void setCreateDyUser(String createDyUser) {
		this.createDyUser = createDyUser;
	}

	public String getCreateDyUserImg() {
		return createDyUserImg;
	}

	public void setCreateDyUserImg(String createDyUserImg) {
		this.createDyUserImg = createDyUserImg;
	}

}