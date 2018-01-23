package cn.aldd.vape.user.micro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aldd.vape.user.micro.repository.mybatis.dao.UserDao;
import cn.aldd.vape.user.micro.service.UserService;
import cn.aldd.vape.user.micro.vo.UserVo;

@Service("messageService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Boolean checkLogin(String loginName, String password) {
		return userDao.checkLogin(loginName, password);
	}

	@Override
	public UserVo findUserById(String id) {
		return userDao.findUserById(id);
	}

}
