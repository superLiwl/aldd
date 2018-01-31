package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.UserSign;
import cn.aldd.vape.user.micro.service.UserSignService;

@RestController
@RequestMapping(value = "/userSign/micro")
public class UserSignMicroController {
	@Autowired
	private UserSignService userSignService;

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}")
	public DataMessage addUserSign(@PathVariable("userId") String userId) {
		UserSign userSign = new UserSign();
		userSign.setUserId(userId);
		UserSign result = userSignService.addUserSign(userSign);
		if(null == result){
			return DataMessage.createSuccessMsg(null, "今日已签到", "");
		}
		return DataMessage.createSuccessMsg(result, "签到成功", "");
	}

}
