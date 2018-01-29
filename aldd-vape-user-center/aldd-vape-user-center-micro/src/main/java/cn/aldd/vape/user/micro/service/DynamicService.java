package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.Dynamic;
import cn.aldd.vape.user.micro.vo.DynamicVo;

public interface DynamicService {

	Dynamic addDynamic(Dynamic dynamic);

	Dynamic updateDynamic(Dynamic dynamic);

	DynamicVo findDynamicById(String id);

	PageInfo<DynamicVo> findDynamicList(DynamicVo dynamicVo, Integer pageNum, Integer pageSize);

	void deleteDynamicById(String id);

}
