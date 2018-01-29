package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
		User oldUSser = userRepository.findOne(user.getId());
		user.setCreateTime(oldUSser.getCreateTime());
		user.setUpdateTime(new Date());
		user = userRepository.save(user);
		return user;
	}

	@Override
	public UserVo findUserById(String id) {
		return userDao.findUserById(id);
	}

	@Override
	public PageInfo<UserVo> findUserList(UserVo userVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<UserVo> result = new PageInfo<UserVo>(userDao.findUserList(userVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		return result;
	}

	@Override
	public void deleteUserById(String id) {
		userRepository.delete(id);
	}

}