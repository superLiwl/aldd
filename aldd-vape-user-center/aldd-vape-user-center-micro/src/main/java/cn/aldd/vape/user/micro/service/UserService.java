package cn.aldd.vape.user.micro.service;

import java.util.List;

import cn.aldd.vape.user.micro.domain.User;
import cn.aldd.vape.user.micro.vo.UserVo;

public interface UserService {

	Boolean checkLogin(String loginName, String password);

	User addUser(User user);

	User updateUser(User user);

	UserVo findUserById(String id);

	List<UserVo> findUserList(UserVo userVo);

	void deleteUserById(String id);

}
