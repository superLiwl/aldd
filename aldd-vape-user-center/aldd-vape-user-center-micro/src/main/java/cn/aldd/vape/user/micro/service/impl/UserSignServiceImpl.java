package cn.aldd.vape.user.micro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.UserRewardCount;
import cn.aldd.vape.user.micro.domain.UserSign;
import cn.aldd.vape.user.micro.repository.jpa.UserSignRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.UserSignDao;
import cn.aldd.vape.user.micro.service.UserRewardCountService;
import cn.aldd.vape.user.micro.service.UserSignService;
import cn.aldd.vape.user.micro.vo.UserSignVo;
import cn.aldd.vape.util.DateUtils;
import cn.aldd.vape.util.Utils;

@Service("userSignService")
public class UserSignServiceImpl implements UserSignService {

	@Autowired
	private UserSignDao userSignDao;
	@Autowired
	private UserSignRepository userSignRepository;
	@Autowired
	private UserRewardCountService userRewardCountService;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public UserSign addUserSign(UserSign userSign) {
		//签到时候增加打赏次数 -- 并且判断今天是否已经签到， 并且判断连续签到几天
		List<String> date = DateUtils.getCurrentWeekRange();
		List<UserSignVo> signList = userSignDao.findWeekUserSignByUserId(userSign.getUserId(), date.get(0), date.get(1));
		if(Utils.isNullList(signList)){
			//为空的时候签到
			userSign.setCreateTime(new Date());
			userSign = userSignRepository.save(userSign);
			//增加打赏次数================================
			UserRewardCount userRewardCount = new UserRewardCount();
			userRewardCount.setUserId(userSign.getUserId());
			userRewardCount.setHaveRewardCount("1");
			userRewardCountService.addUserRewardCount(userRewardCount);
		}else{
			//并且判断今天是否已经签到， 已经签到则返回null
			if(DateUtils.dateFormat(null).equals(DateUtils.dateFormat(signList.get(0).getCreateTime()))){
				return null;
			}else{
				int count = 1;
				int num = DateUtils.getNumDayOfWeek();
				if(num != 0){
					List<String> dateList = new ArrayList<String>();
					for(UserSignVo s : signList){
						dateList.add(DateUtils.dateFormat(s.getCreateTime()));
					}
					List<String> weekDays = DateUtils.getCurrentWeekDays();
					String beforeDay = "";
					
					for(int i = 0;i< num ; i++){
						beforeDay = weekDays.get(num-(i+1));
						if(Utils.isInList(dateList, beforeDay)){
							count++;
						}else{
							break;
						}
					}
				}
				userSign.setCreateTime(new Date());
				userSign = userSignRepository.save(userSign);
				//增加打赏次数================================
				UserRewardCount userRewardCount = new UserRewardCount();
				userRewardCount.setUserId(userSign.getUserId());
				userRewardCount.setHaveRewardCount(count+"");
				userRewardCountService.addUserRewardCount(userRewardCount);
				System.out.println(count);
			}
		}
		return userSign;
	}

	@Override
	public UserSign updateUserSign(UserSign userSign) {
		UserSign oldUSser = userSignRepository.findOne(userSign.getId());
		userSign.setCreateTime(oldUSser.getCreateTime());
		userSign = userSignRepository.save(userSign);
		return userSign;
	}

	@Override
	public UserSignVo findUserSignById(String id) {
		return userSignDao.findUserSignById(id);
	}

	@Override
	public PageInfo<UserSignVo> findUserSignList(UserSignVo userSignVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<UserSignVo> result = new PageInfo<UserSignVo>(userSignDao.findUserSignList(userSignVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		return result;
	}

	@Override
	public void deleteUserSignById(String id) {
		userSignRepository.delete(id);
	}

}