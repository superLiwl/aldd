package cn.aldd.vape.user.micro.service;

import java.util.List;

import cn.aldd.vape.user.micro.domain.DynamicFabulous;
import cn.aldd.vape.user.micro.vo.DynamicFabulousVo;


public interface DynamicFabulousService {
	

	DynamicFabulous addDynamicFabulous(DynamicFabulous dynamicFabulous);

	DynamicFabulous updateDynamicFabulous(DynamicFabulous dynamicFabulous);

	DynamicFabulousVo findDynamicFabulousById(String id);

	List<DynamicFabulousVo> findDynamicFabulousList(DynamicFabulousVo dynamicFabulousVo);

	void deleteDynamicFabulousById(String id);
	
}
