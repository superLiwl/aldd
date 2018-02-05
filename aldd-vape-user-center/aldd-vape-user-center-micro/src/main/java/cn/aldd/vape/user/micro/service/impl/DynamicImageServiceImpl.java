package cn.aldd.vape.user.micro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.aldd.vape.constants.CommonConstants;
import cn.aldd.vape.user.micro.domain.DynamicImage;
import cn.aldd.vape.user.micro.repository.jpa.DynamicImageRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.DynamicImageDao;
import cn.aldd.vape.user.micro.service.DynamicImageService;
import cn.aldd.vape.user.micro.vo.DynamicImageVo;
import cn.aldd.vape.util.Utils;

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
		DynamicImage oldUSser = dynamicImageRepository.findOne(dynamicImage.getId());
		dynamicImage.setCreateTime(oldUSser.getCreateTime());
		dynamicImage = dynamicImageRepository.save(dynamicImage);
		return dynamicImage;
	}

	@Override
	public DynamicImageVo findDynamicImageById(String id) {
		return dynamicImageDao.findDynamicImageById(id);
	}

	@Override
	public List<DynamicImageVo> findDynamicImageListOderHot() {
		List<DynamicImageVo> result = dynamicImageDao.findDynamicImageListOderHot();
		if (!Utils.isNullList(result)) {
			for (DynamicImageVo dynamicImageVo : result) {
				dynamicImageVo.setUrl(CommonConstants.IMG_URL + dynamicImageVo.getUrl());
			}
		}
		return result;
	}

	@Override
	public PageInfo<DynamicImageVo> findDynamicImageList(DynamicImageVo dynamicImageVo, Integer pageNum,
			Integer pageSize) {
		List<DynamicImageVo> hots = dynamicImageDao.findDynamicImageListOderHot();
		if (!Utils.isNullList(hots)) {
			List<String> hotIds = new ArrayList<>();
			for (DynamicImageVo img : hots) {
				hotIds.add(img.getId());
			}
			dynamicImageVo = new DynamicImageVo();
			dynamicImageVo.setHotIds(hotIds);
		}
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<DynamicImageVo> result = new PageInfo<DynamicImageVo>(
				dynamicImageDao.findDynamicImageList(dynamicImageVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		if (!Utils.isNullList(result.getList())) {
			for (DynamicImageVo vo : result.getList()) {
				vo.setUrl(CommonConstants.IMG_URL + vo.getUrl());
			}
		}
		return result;
	}

	@Override
	public void deleteDynamicImageById(String id) {
		dynamicImageRepository.delete(id);
	}

}