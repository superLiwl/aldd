package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.DynamicImage;
import cn.aldd.vape.user.micro.service.DynamicImageService;

@RestController
@RequestMapping(value = "/dynamicImage/micro")
public class DynamicImageMicroController {
	@Autowired
	private DynamicImageService dynamicImageService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addDynamicImage(@RequestBody DynamicImage dynamicImage) {
		return DataMessage.createSuccessMsg(dynamicImageService.addDynamicImage(dynamicImage), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateDynamicImage(@RequestBody DynamicImage dynamicImage) {
		return DataMessage.createSuccessMsg(dynamicImageService.updateDynamicImage(dynamicImage), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findDynamicImageById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(dynamicImageService.findDynamicImageById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{pageNum}/{pageSize}")
	public DataMessage findDynamicImageList(@PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(dynamicImageService.findDynamicImageList(null, pageNum, pageSize), "查询成功",
				"");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/hot")
	public DataMessage findDynamicImageListOderHot() {
		return DataMessage.createSuccessMsg(dynamicImageService.findDynamicImageListOderHot(), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteDynamicImageById(@PathVariable("id") String id) {
		dynamicImageService.deleteDynamicImageById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
