package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
		dynamic = dynamicRepository.save(dynamic);
		return dynamic;
	}

	@Override
	public Dynamic updateDynamic(Dynamic dynamic) {
		Dynamic oldUSser = dynamicRepository.findOne(dynamic.getId());
		dynamic.setCreateTime(oldUSser.getCreateTime());
		dynamic = dynamicRepository.save(dynamic);
		return dynamic;
	}

	@Override
	public DynamicVo findDynamicById(String id) {
		return dynamicDao.findDynamicById(id);
	}

	@Override
	public PageInfo<DynamicVo> findDynamicList(DynamicVo dynamicVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<DynamicVo> result = new PageInfo<DynamicVo>(dynamicDao.findDynamicList(dynamicVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		return result;
	}

	@Override
	public void deleteDynamicById(String id) {
		dynamicRepository.delete(id);
	}

}