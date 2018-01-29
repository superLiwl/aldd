package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.DynamicReward;
import cn.aldd.vape.user.micro.service.DynamicRewardService;
import cn.aldd.vape.user.micro.vo.DynamicRewardVo;

@RestController
@RequestMapping(value = "/dynamicReward/micro")
public class DynamicRewardMicroController {
	@Autowired
	private DynamicRewardService dynamicRewardService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addDynamicReward(@RequestBody DynamicReward dynamicReward) {
		return DataMessage.createSuccessMsg(dynamicRewardService.addDynamicReward(dynamicReward), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateDynamicReward(@RequestBody DynamicReward dynamicReward) {
		return DataMessage.createSuccessMsg(dynamicRewardService.updateDynamicReward(dynamicReward), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findDynamicRewardById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(dynamicRewardService.findDynamicRewardById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findDynamicRewardList(@RequestBody DynamicRewardVo dynamicRewardVo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(dynamicRewardService.findDynamicRewardList(dynamicRewardVo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteDynamicRewardById(@PathVariable("id") String id) {
		dynamicRewardService.deleteDynamicRewardById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
