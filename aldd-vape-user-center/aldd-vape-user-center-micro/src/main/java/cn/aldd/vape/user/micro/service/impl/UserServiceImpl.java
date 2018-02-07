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
import cn.aldd.vape.user.micro.vo.UserRankingVo;
import cn.aldd.vape.user.micro.vo.UserVo;
import cn.aldd.vape.util.DateUtils;
import cn.aldd.vape.util.MD5;

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
		MD5 md5 = new MD5();
		user.setPassword(md5.getMD5ofStr(user.getPassword()));
		user = userRepository.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		User oldUSser = userRepository.findOne(user.getId());
		user.setCreateTime(oldUSser.getCreateTime());// 创建时间不修改
		user.setLoginName(oldUSser.getLoginName());// 登录名不修改
		user.setPassword(oldUSser.getPassword());// 密码不修改
		user.setOpenId(oldUSser.getOpenId());// 微信不修改
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
	public PageInfo<UserRankingVo> findUserRankingList(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		// 计算时间
		String[] dateArry = DateUtils.getStartAndEndTime();
		PageInfo<UserRankingVo> result = new PageInfo<UserRankingVo>(
				userDao.findUserRankingList(dateArry[0], dateArry[1]));
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

	@Override
	public UserVo login(String loginName, String password) {
		MD5 md5 = new MD5();
		return userDao.login(loginName, md5.getMD5ofStr(password));
	}

}