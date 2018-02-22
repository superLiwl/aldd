package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.User;
import cn.aldd.vape.user.micro.vo.UserRankingListVo;
import cn.aldd.vape.user.micro.vo.UserRankingVo;
import cn.aldd.vape.user.micro.vo.UserVo;
import cn.aldd.vape.user.micro.vo.WxUserLoginVo;

public interface UserService {

	User addUser(User user);

	User updateUser(User user);

	UserVo findUserById(String id);

	PageInfo<UserVo> findUserList(UserVo userVo, Integer pageNum, Integer pageSize);

	void deleteUserById(String id);

	PageInfo<UserRankingVo> findUserRankingList(Integer pageNum, Integer pageSize);

	UserRankingVo findMyRanking(String userId, Integer pageNum, Integer pageSize);

	UserRankingListVo findRanks(String userId, Integer pageNum, Integer pageSize);

	PageInfo<UserVo> findNearUsers(String userId, Integer pageNum, Integer pageSize);

	UserVo login(String loginName, String password);

	UserVo wxLogin(WxUserLoginVo wxUserLoginVo);
}
