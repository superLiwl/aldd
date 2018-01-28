package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.aldd.vape.user.micro.domain.DynamicReward;
import cn.aldd.vape.user.micro.repository.jpa.DynamicRewardRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.DynamicRewardDao;
import cn.aldd.vape.user.micro.service.DynamicRewardService;
import cn.aldd.vape.user.micro.vo.DynamicRewardVo;

@Service("dynamicRewardService")
public class DynamicRewardServiceImpl implements DynamicRewardService {

	@Autowired
	private DynamicRewardDao dynamicRewardDao;
	@Autowired
	private DynamicRewardRepository dynamicRewardRepository;

	@Override
	public DynamicReward addDynamicReward(DynamicReward dynamicReward) {
		dynamicReward.setCreateTime(new Date());
		dynamicReward = dynamicRewardRepository.save(dynamicReward);
		return dynamicReward;
	}

	@Override
	public DynamicReward updateDynamicReward(DynamicReward dynamicReward) {
		dynamicReward = dynamicRewardRepository.save(dynamicReward);
		return dynamicReward;
	}

	@Override
	public DynamicRewardVo findDynamicRewardById(String id) {
		return dynamicRewardDao.findDynamicRewardById(id);
	}

	@Override
	public List<DynamicRewardVo> findDynamicRewardList(DynamicRewardVo dynamicRewardVo) {
		PageHelper.startPage(dynamicRewardVo.getPageNum(), dynamicRewardVo.getPageSize());
		List<DynamicRewardVo> result = dynamicRewardDao.findDynamicRewardList(dynamicRewardVo);
		return result;
	}

	@Override
	public void deleteDynamicRewardById(String id) {
		dynamicRewardRepository.delete(id);
	}

}