package cn.aldd.vape.user.micro.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class DynamicVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键id")
	private String id;
	@ApiModelProperty(value = "发表地址")
	private String address;
	@ApiModelProperty(value = "动态内容")
	private String content;
	@ApiModelProperty(value = "创建人")
	private String createUserId;
	@ApiModelProperty(value = "昵称")
	private String nickName;
	@ApiModelProperty(value = "头像")
	private String headPortraitImg;
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date createTime;
	@ApiModelProperty(value = "动态内容图片")
	private List<DynamicImageVo> images;
	@ApiModelProperty(value = "动态点赞")
	private List<DynamicFabulousVo> fabulous;
	@ApiModelProperty(value = "动态打赏")
	private List<DynamicRewardVo> rewards;
	@ApiModelProperty(value = "动态评论")
	private List<DynamicCommentVo> comments;
	@ApiModelProperty(value = "是否关注")
	private Boolean isFollow;
	@ApiModelProperty(value = "简介")
	private String describe;

	// setter and getter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public List<DynamicImageVo> getImages() {
		return images;
	}

	public void setImages(List<DynamicImageVo> images) {
		this.images = images;
	}

	public List<DynamicFabulousVo> getFabulous() {
		return fabulous;
	}

	public void setFabulous(List<DynamicFabulousVo> fabulous) {
		this.fabulous = fabulous;
	}

	public List<DynamicRewardVo> getRewards() {
		return rewards;
	}

	public void setRewards(List<DynamicRewardVo> rewards) {
		this.rewards = rewards;
	}

	public List<DynamicCommentVo> getComments() {
		return comments;
	}

	public void setComments(List<DynamicCommentVo> comments) {
		this.comments = comments;
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

	public Boolean getIsFollow() {
		return isFollow;
	}

	public void setIsFollow(Boolean isFollow) {
		this.isFollow = isFollow;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

}