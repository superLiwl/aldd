package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.UserFollow;
import cn.aldd.vape.user.micro.repository.jpa.UserFollowRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.UserFollowDao;
import cn.aldd.vape.user.micro.service.UserFollowService;
import cn.aldd.vape.user.micro.vo.UserFollowVo;

@Service("userFollowService")
public class UserFollowServiceImpl implements UserFollowService {

	@Autowired
	private UserFollowDao userFollowDao;
	@Autowired
	private UserFollowRepository userFollowRepository;

	@Override
	public UserFollow addUserFollow(UserFollow userFollow) {
		userFollow.setCreateTime(new Date());
		userFollow = userFollowRepository.save(userFollow);
		return userFollow;
	}

	@Override
	public UserFollow updateUserFollow(UserFollow userFollow) {
		UserFollow oldUSser = userFollowRepository.findOne(userFollow.getId());
		userFollow.setCreateTime(oldUSser.getCreateTime());
		userFollow = userFollowRepository.save(userFollow);
		return userFollow;
	}

	@Override
	public UserFollowVo findUserFollowById(String id) {
		return userFollowDao.findUserFollowById(id);
	}

	@Override
	public PageInfo<UserFollowVo> findUserFollowList(UserFollowVo userFollowVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<UserFollowVo> result = new PageInfo<UserFollowVo>(userFollowDao.findUserFollowList(userFollowVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		return result;
	}

	@Override
	public void deleteUserFollowById(String id) {
		userFollowRepository.delete(id);
	}

}