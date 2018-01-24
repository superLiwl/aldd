package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.aldd.vape.user.micro.domain.Dynamic;
import cn.aldd.vape.user.micro.repository.jpa.DynamicRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.DynamicDao;
import cn.aldd.vape.user.micro.service.DynamicService;
import cn.aldd.vape.user.micro.vo.DynamicVo;

@Service("dynamicService")
public class DynamicServiceImpl implements DynamicService {

	@Autowired
	private DynamicDao dynamicDao;
	@Autowired
	private DynamicRepository dynamicRepository;

	@Override
	public Dynamic addDynamic(Dynamic dynamic) {
		dynamic.setCreateTime(new Date());
		dynamic.setUpdateTime(new Date());
		dynamic = dynamicRepository.save(dynamic);
		return dynamic;
	}

	@Override
	public Dynamic updateDynamic(Dynamic dynamic) {
		dynamic.setUpdateTime(new Date());
		dynamic = dynamicRepository.save(dynamic);
		return dynamic;
	}

	@Override
	public DynamicVo findDynamicById(String id) {
		return dynamicDao.findDynamicById(id);
	}

	@Override
	public List<DynamicVo> findDynamicList(DynamicVo dynamicVo) {
		PageHelper.startPage(dynamicVo.getPageNum(), dynamicVo.getPageSize());
		List<DynamicVo> result = dynamicDao.findDynamicList(dynamicVo);
		return result;
	}

	@Override
	public void deleteDynamicById(String id) {
		dynamicRepository.delete(id);
	}

}