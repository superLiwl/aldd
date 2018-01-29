package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.DynamicReward;
import cn.aldd.vape.user.micro.vo.DynamicRewardVo;

public interface DynamicRewardService {

	DynamicReward addDynamicReward(DynamicReward dynamicReward);

	DynamicReward updateDynamicReward(DynamicReward dynamicReward);

	DynamicRewardVo findDynamicRewardById(String id);

	PageInfo<DynamicRewardVo> findDynamicRewardList(DynamicRewardVo dynamicRewardVo, Integer pageNum, Integer pageSize);

	void deleteDynamicRewardById(String id);

}
