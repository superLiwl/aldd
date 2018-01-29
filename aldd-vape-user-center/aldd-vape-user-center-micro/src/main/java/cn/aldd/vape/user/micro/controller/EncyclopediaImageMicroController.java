package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.EncyclopediaImage;
import cn.aldd.vape.user.micro.service.EncyclopediaImageService;
import cn.aldd.vape.user.micro.vo.EncyclopediaImageVo;

@RestController
@RequestMapping(value = "/encyclopediaImage/micro")
public class EncyclopediaImageMicroController {
	@Autowired
	private EncyclopediaImageService encyclopediaImageService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addEncyclopediaImage(@RequestBody EncyclopediaImage encyclopediaImage) {
		return DataMessage.createSuccessMsg(encyclopediaImageService.addEncyclopediaImage(encyclopediaImage), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateEncyclopediaImage(@RequestBody EncyclopediaImage encyclopediaImage) {
		return DataMessage.createSuccessMsg(encyclopediaImageService.updateEncyclopediaImage(encyclopediaImage), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findEncyclopediaImageById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(encyclopediaImageService.findEncyclopediaImageById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findEncyclopediaImageList(@RequestBody EncyclopediaImageVo encyclopediaImageVo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(encyclopediaImageService.findEncyclopediaImageList(encyclopediaImageVo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteEncyclopediaImageById(@PathVariable("id") String id) {
		encyclopediaImageService.deleteEncyclopediaImageById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
