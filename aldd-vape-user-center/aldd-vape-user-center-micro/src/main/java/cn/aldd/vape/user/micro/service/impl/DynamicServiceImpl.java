package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.Dynamic;
import cn.aldd.vape.user.micro.domain.DynamicImage;
import cn.aldd.vape.user.micro.repository.jpa.DynamicRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.DynamicDao;
import cn.aldd.vape.user.micro.service.DynamicImageService;
import cn.aldd.vape.user.micro.service.DynamicService;
import cn.aldd.vape.user.micro.vo.DynamicVo;
import cn.aldd.vape.util.Utils;

@Service("dynamicService")
public class DynamicServiceImpl implements DynamicService {

	@Autowired
	private DynamicDao dynamicDao;
	@Autowired
	private DynamicRepository dynamicRepository;
	@Autowired
	private DynamicImageService dynamicImageService;

	@Override
	public Dynamic addDynamic(Dynamic dynamic) {
		dynamic.setCreateTime(new Date());
		dynamic = dynamicRepository.save(dynamic);
		// 增加动态图片
		DynamicImage dynamicImage;
		if (!Utils.isNullList(dynamic.getImages())) {
			for (String url : dynamic.getImages()) {
				if (StringUtils.isNotBlank(url)) {
					dynamicImage = new DynamicImage();
					dynamicImage.setDynamicId(dynamic.getId());
					dynamicImage.setUrl(url);
					dynamicImage.setType(dynamic.getType());
					dynamicImageService.addDynamicImage(dynamicImage);
				}
			}
		}

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