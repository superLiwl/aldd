package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.Encyclopedia;
import cn.aldd.vape.user.micro.service.EncyclopediaService;
import cn.aldd.vape.user.micro.vo.EncyclopediaVo;

@RestController
@RequestMapping(value = "/encyclopedia/micro")
public class EncyclopediaMicroController {
	@Autowired
	private EncyclopediaService encyclopediaService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addEncyclopedia(@RequestBody Encyclopedia encyclopedia) {
		return DataMessage.createSuccessMsg(encyclopediaService.addEncyclopedia(encyclopedia), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateEncyclopedia(@RequestBody Encyclopedia encyclopedia) {
		return DataMessage.createSuccessMsg(encyclopediaService.updateEncyclopedia(encyclopedia), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findEncyclopediaById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(encyclopediaService.findEncyclopediaById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findEncyclopediaList(@RequestBody EncyclopediaVo encyclopediaVo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(encyclopediaService.findEncyclopediaList(encyclopediaVo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
	public DataMessage deleteEncyclopediaById(@PathVariable("id") String id) {
		encyclopediaService.deleteEncyclopediaById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
