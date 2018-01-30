package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.DynamicFabulous;
import cn.aldd.vape.user.micro.service.DynamicFabulousService;

@RestController
@RequestMapping(value = "/dynamicFabulous/micro")
public class DynamicFabulousMicroController {
	@Autowired
	private DynamicFabulousService dynamicFabulousService;

	@RequestMapping(method = RequestMethod.GET, value = "/{dynamicId}/{userId}")
	public DataMessage addDynamicFabulous(@PathVariable("dynamicId") String dynamicId,@PathVariable("userId") String userId) {
		DynamicFabulous dynamicFabulous = new DynamicFabulous();
		dynamicFabulous.setDynamicId(dynamicId);
		dynamicFabulous.setCreateUserId(userId);
		dynamicFabulous = dynamicFabulousService.addDynamicFabulous(dynamicFabulous);
		if(null == dynamicFabulous){
			return DataMessage.createSuccessMsg(dynamicFabulous, "取消点赞成功", "");
		}else{
			return DataMessage.createSuccessMsg(dynamicFabulous, "点赞成功", "");
		}
	}

}
