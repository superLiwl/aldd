package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.aldd.vape.user.micro.domain.DynamicFabulous;
import cn.aldd.vape.user.micro.repository.jpa.DynamicFabulousRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.DynamicFabulousDao;
import cn.aldd.vape.user.micro.service.DynamicFabulousService;
import cn.aldd.vape.user.micro.vo.DynamicFabulousVo;

@Service("dynamicFabulousService")
public class DynamicFabulousServiceImpl implements DynamicFabulousService {

	@Autowired
	private DynamicFabulousDao dynamicFabulousDao;
	@Autowired
	private DynamicFabulousRepository dynamicFabulousRepository;

	@Override
	public DynamicFabulous addDynamicFabulous(DynamicFabulous dynamicFabulous) {
		dynamicFabulous.setCreateTime(new Date());
		dynamicFabulous = dynamicFabulousRepository.save(dynamicFabulous);
		return dynamicFabulous;
	}

	@Override
	public DynamicFabulous updateDynamicFabulous(DynamicFabulous dynamicFabulous) {
		dynamicFabulous = dynamicFabulousRepository.save(dynamicFabulous);
		return dynamicFabulous;
	}

	@Override
	public DynamicFabulousVo findDynamicFabulousById(String id) {
		return dynamicFabulousDao.findDynamicFabulousById(id);
	}

	@Override
	public List<DynamicFabulousVo> findDynamicFabulousList(DynamicFabulousVo dynamicFabulousVo) {
		PageHelper.startPage(dynamicFabulousVo.getPageNum(), dynamicFabulousVo.getPageSize());
		List<DynamicFabulousVo> result = dynamicFabulousDao.findDynamicFabulousList(dynamicFabulousVo);
		return result;
	}

	@Override
	public void deleteDynamicFabulousById(String id) {
		dynamicFabulousRepository.delete(id);
	}

}