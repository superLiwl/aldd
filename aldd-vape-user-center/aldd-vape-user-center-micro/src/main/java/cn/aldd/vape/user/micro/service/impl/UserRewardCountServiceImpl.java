package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.UserRewardCount;
import cn.aldd.vape.user.micro.repository.jpa.UserRewardCountRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.UserRewardCountDao;
import cn.aldd.vape.user.micro.service.UserRewardCountService;
import cn.aldd.vape.user.micro.vo.UserRewardCountVo;
import cn.aldd.vape.util.Utils;

@Service("userRewardCountService")
public class UserRewardCountServiceImpl implements UserRewardCountService {

	@Autowired
	private UserRewardCountDao userRewardCountDao;
	@Autowired
	private UserRewardCountRepository userRewardCountRepository;

	@Override
	public UserRewardCount addUserRewardCount(UserRewardCount userRewardCount) {
		//需要判断今天是否已经增加了打赏次数，并且每日最多增加打赏次数为30
		UserRewardCountVo countVo = userRewardCountDao.findTodayUserRewardCountByUserId(userRewardCount.getUserId());
		if(null == countVo){
			userRewardCount.setCreateTime(new Date());
			userRewardCount.setUsedRewardCount("0");
			userRewardCount = userRewardCountRepository.save(userRewardCount);
		}else{
			String count = Utils.add(countVo.getHaveRewardCount(), userRewardCount.getHaveRewardCount());
			if(Integer.parseInt(count)>= 30){
				count = "30";
			}
			userRewardCount.setHaveRewardCount(count);
			userRewardCount.setId(countVo.getId());
			userRewardCount.setCreateTime(countVo.getCreateTime());
			userRewardCount.setUsedRewardCount(countVo.getUsedRewardCount());
			userRewardCount.setUserId(userRewardCount.getUserId());
			userRewardCount = userRewardCountRepository.save(userRewardCount);
		}
		return userRewardCount;
	}

	@Override
	public UserRewardCount updateUserRewardCount(UserRewardCount userRewardCount) {
		UserRewardCount oldUSser = userRewardCountRepository.findOne(userRewardCount.getId());
		userRewardCount.setCreateTime(oldUSser.getCreateTime());
		userRewardCount = userRewardCountRepository.save(userRewardCount);
		return userRewardCount;
	}

	@Override
	public UserRewardCountVo findUserRewardCountById(String id) {
		return userRewardCountDao.findUserRewardCountById(id);
	}

	@Override
	public PageInfo<UserRewardCountVo> findUserRewardCountList(UserRewardCountVo userRewardCountVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<UserRewardCountVo> result = new PageInfo<UserRewardCountVo>(userRewardCountDao.findUserRewardCountList(userRewardCountVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		return result;
	}

	@Override
	public void deleteUserRewardCountById(String id) {
		userRewardCountRepository.delete(id);
	}

}