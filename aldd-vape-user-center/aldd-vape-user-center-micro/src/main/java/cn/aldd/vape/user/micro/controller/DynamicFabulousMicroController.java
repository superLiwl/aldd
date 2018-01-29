package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.DynamicFabulous;
import cn.aldd.vape.user.micro.service.DynamicFabulousService;
import cn.aldd.vape.user.micro.vo.DynamicFabulousVo;

@RestController
@RequestMapping(value = "/dynamicFabulous/micro")
public class DynamicFabulousMicroController {
	@Autowired
	private DynamicFabulousService dynamicFabulousService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addDynamicFabulous(@RequestBody DynamicFabulous dynamicFabulous) {
		return DataMessage.createSuccessMsg(dynamicFabulousService.addDynamicFabulous(dynamicFabulous), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateDynamicFabulous(@RequestBody DynamicFabulous dynamicFabulous) {
		return DataMessage.createSuccessMsg(dynamicFabulousService.updateDynamicFabulous(dynamicFabulous), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findDynamicFabulousById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(dynamicFabulousService.findDynamicFabulousById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findDynamicFabulousList(@RequestBody DynamicFabulousVo dynamicFabulousVo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(dynamicFabulousService.findDynamicFabulousList(dynamicFabulousVo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteDynamicFabulousById(@PathVariable("id") String id) {
		dynamicFabulousService.deleteDynamicFabulousById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
