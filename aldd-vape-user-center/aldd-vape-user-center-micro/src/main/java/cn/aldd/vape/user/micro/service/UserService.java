package cn.aldd.vape.user.micro.service;

import cn.aldd.vape.user.micro.vo.UserVo;

public interface UserService {

	Boolean checkLogin(String loginName, String password);

	UserVo findUserById(String id);
}
