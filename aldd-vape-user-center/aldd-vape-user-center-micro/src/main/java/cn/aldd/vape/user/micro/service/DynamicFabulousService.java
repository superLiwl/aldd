package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.DynamicFabulous;
import cn.aldd.vape.user.micro.vo.DynamicFabulousVo;

public interface DynamicFabulousService {

	DynamicFabulous addDynamicFabulous(DynamicFabulous dynamicFabulous);

	DynamicFabulous updateDynamicFabulous(DynamicFabulous dynamicFabulous);

	DynamicFabulousVo findDynamicFabulousById(String id);

	PageInfo<DynamicFabulousVo> findDynamicFabulousList(DynamicFabulousVo dynamicFabulousVo, Integer pageNum, Integer pageSize);

	void deleteDynamicFabulousById(String id);

}
