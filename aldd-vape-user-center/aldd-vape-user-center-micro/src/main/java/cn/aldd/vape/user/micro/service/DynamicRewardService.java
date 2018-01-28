package cn.aldd.vape.user.micro.service;

import java.util.List;

import cn.aldd.vape.user.micro.domain.DynamicReward;
import cn.aldd.vape.user.micro.vo.DynamicRewardVo;


public interface DynamicRewardService {
	

	DynamicReward addDynamicReward(DynamicReward dynamicReward);

	DynamicReward updateDynamicReward(DynamicReward dynamicReward);

	DynamicRewardVo findDynamicRewardById(String id);

	List<DynamicRewardVo> findDynamicRewardList(DynamicRewardVo dynamicRewardVo);

	void deleteDynamicRewardById(String id);
	
}
