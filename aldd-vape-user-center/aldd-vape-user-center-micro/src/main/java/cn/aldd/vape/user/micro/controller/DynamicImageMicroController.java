package cn.aldd.vape.user.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.user.micro.domain.DynamicImage;
import cn.aldd.vape.user.micro.service.DynamicImageService;
import cn.aldd.vape.user.micro.vo.DynamicImageVo;

@RestController
public class DynamicImageMicroController {
	@Autowired
	private DynamicImageService dynamicImageService;

	@RequestMapping(method = RequestMethod.POST, value = "/dynamicImage/micro/addDynamicImage")
	public DynamicImage addDynamicImage(@RequestBody DynamicImage dynamicImage) {
		return dynamicImageService.addDynamicImage(dynamicImage);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dynamicImage/micro/updateDynamicImage")
	public DynamicImage updateDynamicImage(@RequestBody DynamicImage dynamicImage) {
		return dynamicImageService.updateDynamicImage(dynamicImage);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dynamicImage/micro/{id}")
	public DynamicImageVo findDynamicImageById(@PathVariable("id") String id) {
		return dynamicImageService.findDynamicImageById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dynamicImage/micro/findDynamicImageList")
	public List<DynamicImageVo> findDynamicImageList(@RequestBody DynamicImageVo dynamicImageVo) {
		return dynamicImageService.findDynamicImageList(dynamicImageVo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/dynamicImage/micro/{id}")
	public void deleteDynamicImageById(@PathVariable("id") String id) {
		dynamicImageService.deleteDynamicImageById(id);
	}

}
