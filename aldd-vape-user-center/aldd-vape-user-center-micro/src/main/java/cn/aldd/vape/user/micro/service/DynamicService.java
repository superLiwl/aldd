package cn.aldd.vape.user.micro.service;

import java.util.List;

import cn.aldd.vape.user.micro.domain.Dynamic;
import cn.aldd.vape.user.micro.vo.DynamicVo;


public interface DynamicService {
	

	Dynamic addDynamic(Dynamic dynamic);

	Dynamic updateDynamic(Dynamic dynamic);

	DynamicVo findDynamicById(String id);

	List<DynamicVo> findDynamicList(DynamicVo dynamicVo);

	void deleteDynamicById(String id);
	
}
