package cn.aldd.vape.user.micro.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.DynamicImage;
import cn.aldd.vape.user.micro.vo.DynamicImageVo;

public interface DynamicImageService {

	DynamicImage addDynamicImage(DynamicImage dynamicImage);

	DynamicImage updateDynamicImage(DynamicImage dynamicImage);

	DynamicImageVo findDynamicImageById(String id);

	PageInfo<DynamicImageVo> findDynamicImageList(DynamicImageVo dynamicImageVo, Integer pageNum, Integer pageSize);

	void deleteDynamicImageById(String id);

	List<DynamicImageVo> findDynamicImageListOderHot();
}
