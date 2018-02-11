package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.aldd.vape.constants.CommonConstants;
import cn.aldd.vape.user.micro.domain.User;
import cn.aldd.vape.user.micro.repository.jpa.UserRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.UserDao;
import cn.aldd.vape.user.micro.service.UserService;
import cn.aldd.vape.user.micro.vo.UserRankingListVo;
import cn.aldd.vape.user.micro.vo.UserRankingVo;
import cn.aldd.vape.user.micro.vo.UserVo;
import cn.aldd.vape.util.DateUtils;
import cn.aldd.vape.util.MD5;
import cn.aldd.vape.util.Utils;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		// 判断是否已经存在根据openid判断
		UserVo userVo = findUserById(user.getOpenId());
		if (null != userVo) {
			user.setId(userVo.getId());
			updateUser(user);
		} else {
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			MD5 md5 = new MD5();
			user.setPassword(md5.getMD5ofStr(user.getPassword()));
			user = userRepository.save(user);
		}
		if (!user.getHeadPortraitImg().contains("http")) {
			user.setHeadPortraitImg(CommonConstants.IMG_URL + user.getHeadPortraitImg());
		}
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
	public UserRankingListVo findRanks(String userId, Integer pageNum, Integer pageSize) {
		PageInfo<UserRankingVo> ranks = findUserRankingList(pageNum, pageSize);
		UserRankingVo myRank = findMyRanking(userId, pageNum, pageSize);
		UserRankingListVo result = new UserRankingListVo();
		result.setUserRanks(ranks.getList());
		result.setMyRanks(myRank);
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
		if (!Utils.isNullList(result.getList())) {
			for (UserRankingVo vo : result.getList()) {
				if (!vo.getHeadPortraitImg().contains("http")) {
					vo.setHeadPortraitImg(CommonConstants.IMG_URL + vo.getHeadPortraitImg());
				}
			}
		}
		return result;
	}

	@Override
	public PageInfo<UserVo> findNearUsers(String userId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<UserVo> result = new PageInfo<UserVo>(userDao.findNearUsers(userId));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		if (!Utils.isNullList(result.getList())) {
			for (UserVo vo : result.getList()) {
				if (!vo.getHeadPortraitImg().contains("http")) {
					vo.setHeadPortraitImg(CommonConstants.IMG_URL + vo.getHeadPortraitImg());
				}
			}
		}
		return result;
	}

	@Override
	public UserRankingVo findMyRanking(String userId, Integer pageNum, Integer pageSize) {
		String[] dateArry = DateUtils.getStartAndEndTime();
		UserRankingVo vo = userDao.findMyRanking(userId, dateArry[0], dateArry[1]);
		if (null != vo && !vo.getHeadPortraitImg().contains("http")) {
			vo.setHeadPortraitImg(CommonConstants.IMG_URL + vo.getHeadPortraitImg());
		}
		return vo;
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

	@Override
	public UserVo wxLogin(String id, String longitude, String latitude) {
		//更新经纬度
		
		return findUserById(id);
	}

}