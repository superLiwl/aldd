package cn.aldd.vape.user.micro.service;

import java.util.List;

import cn.aldd.vape.user.micro.domain.UserFollow;
import cn.aldd.vape.user.micro.vo.UserFollowVo;


public interface UserFollowService {
	

	UserFollow addUserFollow(UserFollow userFollow);

	UserFollow updateUserFollow(UserFollow userFollow);

	UserFollowVo findUserFollowById(String id);

	List<UserFollowVo> findUserFollowList(UserFollowVo userFollowVo);

	void deleteUserFollowById(String id);
	
}
