package cn.aldd.vape.user.micro.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class UserRankingVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户id")
	private String userId;
	@ApiModelProperty(value = "排名")
	private String rowno;
	@ApiModelProperty(value = "昵称")
	private String nickName;
	@ApiModelProperty(value = "头像")
	private String headPortraitImg;
	@ApiModelProperty(value = "数量")
	private String rewardCount;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getRewardCount() {
		return rewardCount;
	}

	public void setRewardCount(String rewardCount) {
		this.rewardCount = rewardCount;
	}

	public String getRowno() {
		return rowno;
	}

	public void setRowno(String rowno) {
		this.rowno = rowno;
	}

}