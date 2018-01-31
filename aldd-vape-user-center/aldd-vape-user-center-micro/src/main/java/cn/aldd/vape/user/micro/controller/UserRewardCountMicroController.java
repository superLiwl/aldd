package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.UserRewardCount;
import cn.aldd.vape.user.micro.service.UserRewardCountService;
import cn.aldd.vape.user.micro.vo.UserRewardCountVo;

@RestController
@RequestMapping(value = "/userRewardCount/micro")
public class UserRewardCountMicroController {
	@Autowired
	private UserRewardCountService userRewardCountService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addUserRewardCount(@RequestBody UserRewardCount userRewardCount) {
		return DataMessage.createSuccessMsg(userRewardCountService.addUserRewardCount(userRewardCount), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateUserRewardCount(@RequestBody UserRewardCount userRewardCount) {
		return DataMessage.createSuccessMsg(userRewardCountService.updateUserRewardCount(userRewardCount), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findUserRewardCountById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(userRewardCountService.findUserRewardCountById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findUserRewardCountList(@RequestBody UserRewardCountVo userRewardCountVo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(userRewardCountService.findUserRewardCountList(userRewardCountVo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteUserRewardCountById(@PathVariable("id") String id) {
		userRewardCountService.deleteUserRewardCountById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
