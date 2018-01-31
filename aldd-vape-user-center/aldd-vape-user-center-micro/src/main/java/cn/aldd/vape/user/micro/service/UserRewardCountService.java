package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.UserRewardCount;
import cn.aldd.vape.user.micro.vo.UserRewardCountVo;

public interface UserRewardCountService {

	UserRewardCount addUserRewardCount(UserRewardCount userRewardCount);

	UserRewardCount updateUserRewardCount(UserRewardCount userRewardCount);

	UserRewardCountVo findUserRewardCountById(String id);

	PageInfo<UserRewardCountVo> findUserRewardCountList(UserRewardCountVo userRewardCountVo, Integer pageNum, Integer pageSize);

	void deleteUserRewardCountById(String id);

}
