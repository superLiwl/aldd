package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.aldd.vape.user.micro.domain.DynamicImage;
import cn.aldd.vape.user.micro.repository.jpa.DynamicImageRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.DynamicImageDao;
import cn.aldd.vape.user.micro.service.DynamicImageService;
import cn.aldd.vape.user.micro.vo.DynamicImageVo;

@Service("dynamicImageService")
public class DynamicImageServiceImpl implements DynamicImageService {

	@Autowired
	private DynamicImageDao dynamicImageDao;
	@Autowired
	private DynamicImageRepository dynamicImageRepository;

	@Override
	public DynamicImage addDynamicImage(DynamicImage dynamicImage) {
		dynamicImage.setCreateTime(new Date());
		dynamicImage = dynamicImageRepository.save(dynamicImage);
		return dynamicImage;
	}

	@Override
	public DynamicImage updateDynamicImage(DynamicImage dynamicImage) {
		dynamicImage = dynamicImageRepository.save(dynamicImage);
		return dynamicImage;
	}

	@Override
	public DynamicImageVo findDynamicImageById(String id) {
		return dynamicImageDao.findDynamicImageById(id);
	}

	@Override
	public List<DynamicImageVo> findDynamicImageList(DynamicImageVo dynamicImageVo) {
		PageHelper.startPage(dynamicImageVo.getPageNum(), dynamicImageVo.getPageSize());
		List<DynamicImageVo> result = dynamicImageDao.findDynamicImageList(dynamicImageVo);
		return result;
	}

	@Override
	public void deleteDynamicImageById(String id) {
		dynamicImageRepository.delete(id);
	}

}