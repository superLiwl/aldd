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

	@RequestMapping(method = RequestMethod.GET, value = "/{dynamicId}/{userId}")
	public DataMessage addDynamicReward(@PathVariable("dynamicId") String dynamicId,
			@PathVariable("userId") String userId) {
		DynamicReward dynamicReward = new DynamicReward();
		dynamicReward.setDynamicId(dynamicId);
		dynamicReward.setCreateUserId(userId);
		dynamicReward = dynamicRewardService.addDynamicReward(dynamicReward);
		if(null == dynamicReward){
			return DataMessage.createSuccessMsg(null, "打赏次数已经用完", "");
		}
		return DataMessage.createSuccessMsg(dynamicReward, "打赏成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findDynamicRewardList(@RequestBody DynamicRewardVo dynamicRewardVo,
			@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(
				dynamicRewardService.findDynamicRewardList(dynamicRewardVo, pageNum, pageSize), "查询成功", "");
	}

}
