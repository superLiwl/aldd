package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.Dynamic;
import cn.aldd.vape.user.micro.service.DynamicService;
import cn.aldd.vape.user.micro.vo.DynamicVo;

@RestController
@RequestMapping(value = "/dynamic/micro")
public class DynamicMicroController {
	@Autowired
	private DynamicService dynamicService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addDynamic(@RequestBody Dynamic dynamic) {
		return DataMessage.createSuccessMsg(dynamicService.addDynamic(dynamic), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateDynamic(@RequestBody Dynamic dynamic) {
		return DataMessage.createSuccessMsg(dynamicService.updateDynamic(dynamic), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findDynamicById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(dynamicService.findDynamicById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findDynamicList(@RequestBody DynamicVo dynamicVo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(dynamicService.findDynamicList(dynamicVo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteDynamicById(@PathVariable("id") String id) {
		dynamicService.deleteDynamicById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
