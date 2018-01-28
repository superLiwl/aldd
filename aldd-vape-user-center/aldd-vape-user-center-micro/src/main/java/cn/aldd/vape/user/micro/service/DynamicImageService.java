package cn.aldd.vape.user.micro.service;

import java.util.List;

import cn.aldd.vape.user.micro.domain.DynamicImage;
import cn.aldd.vape.user.micro.vo.DynamicImageVo;


public interface DynamicImageService {
	

	DynamicImage addDynamicImage(DynamicImage dynamicImage);

	DynamicImage updateDynamicImage(DynamicImage dynamicImage);

	DynamicImageVo findDynamicImageById(String id);

	List<DynamicImageVo> findDynamicImageList(DynamicImageVo dynamicImageVo);

	void deleteDynamicImageById(String id);
	
}
