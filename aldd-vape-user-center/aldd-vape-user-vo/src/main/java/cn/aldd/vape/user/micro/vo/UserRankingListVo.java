package cn.aldd.vape.user.micro.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class UserRankingListVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户排行榜")
	private List<UserRankingVo> userRanks;

	@ApiModelProperty(value = "我的拍卖")
	private UserRankingVo myRanks;

	public List<UserRankingVo> getUserRanks() {
		return userRanks;
	}

	public void setUserRanks(List<UserRankingVo> userRanks) {
		this.userRanks = userRanks;
	}

	public UserRankingVo getMyRanks() {
		return myRanks;
	}

	public void setMyRanks(UserRankingVo myRanks) {
		this.myRanks = myRanks;
	}

}