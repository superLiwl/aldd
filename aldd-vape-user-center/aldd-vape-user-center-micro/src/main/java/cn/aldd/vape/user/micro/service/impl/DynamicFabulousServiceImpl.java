package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
		DynamicFabulous oldUSser = dynamicFabulousRepository.findOne(dynamicFabulous.getId());
		dynamicFabulous.setCreateTime(oldUSser.getCreateTime());
		dynamicFabulous = dynamicFabulousRepository.save(dynamicFabulous);
		return dynamicFabulous;
	}

	@Override
	public DynamicFabulousVo findDynamicFabulousById(String id) {
		return dynamicFabulousDao.findDynamicFabulousById(id);
	}

	@Override
	public PageInfo<DynamicFabulousVo> findDynamicFabulousList(DynamicFabulousVo dynamicFabulousVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<DynamicFabulousVo> result = new PageInfo<DynamicFabulousVo>(dynamicFabulousDao.findDynamicFabulousList(dynamicFabulousVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		return result;
	}

	@Override
	public void deleteDynamicFabulousById(String id) {
		dynamicFabulousRepository.delete(id);
	}

}