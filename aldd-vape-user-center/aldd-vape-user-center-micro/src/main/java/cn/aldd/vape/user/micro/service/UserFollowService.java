package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.UserFollow;
import cn.aldd.vape.user.micro.vo.UserFollowVo;

public interface UserFollowService {

	UserFollow addUserFollow(UserFollow userFollow);

	UserFollow updateUserFollow(UserFollow userFollow);

	UserFollowVo findUserFollowById(String id);

	PageInfo<UserFollowVo> findUserFollowList(UserFollowVo userFollowVo, Integer pageNum, Integer pageSize);

	void deleteUserFollowById(String id);

}
