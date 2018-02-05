package cn.aldd.vape.user.micro.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class DynamicCommentVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键id")
	private String id;
	@ApiModelProperty(value = "评论id")
	private String commentId;
	@ApiModelProperty(value = "动态id")
	private String dynamicId;
	@ApiModelProperty(value = "评论内容")
	private String comment;
	@ApiModelProperty(value = "创建人")
	private String createUserId;
	@ApiModelProperty(value = "昵称")
	private String nickName;
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date createTime;
	@ApiModelProperty(value = "动态发表人id")
	private String createDyUser;
	@ApiModelProperty(value = "动态发表人头像")
	private String createDyUserImg;

	// setter and getter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getDynamicId() {
		return dynamicId;
	}

	public void setDynamicId(String dynamicId) {
		this.dynamicId = dynamicId;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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