package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.aldd.vape.user.micro.domain.User;
import cn.aldd.vape.user.micro.repository.jpa.UserRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.UserDao;
import cn.aldd.vape.user.micro.service.UserService;
import cn.aldd.vape.user.micro.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		user = userRepository.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		user.setUpdateTime(new Date());
		user = userRepository.save(user);
		return user;
	}

	@Override
	public UserVo findUserById(String id) {
		return userDao.findUserById(id);
	}

	@Override
	public List<UserVo> findUserList(UserVo userVo) {
		PageHelper.startPage(userVo.getPageNum(), userVo.getPageSize());
		List<UserVo> result = userDao.findUserList(userVo);
		return result;
	}

	@Override
	public void deleteUserById(String id) {
		userRepository.delete(id);
	}

}