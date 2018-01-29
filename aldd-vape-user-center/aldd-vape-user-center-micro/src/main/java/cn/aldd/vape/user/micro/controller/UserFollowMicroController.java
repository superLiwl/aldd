package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.UserFollow;
import cn.aldd.vape.user.micro.service.UserFollowService;
import cn.aldd.vape.user.micro.vo.UserFollowVo;

@RestController
@RequestMapping(value = "/userFollow/micro")
public class UserFollowMicroController {
	@Autowired
	private UserFollowService userFollowService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addUserFollow(@RequestBody UserFollow userFollow) {
		return DataMessage.createSuccessMsg(userFollowService.addUserFollow(userFollow), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateUserFollow(@RequestBody UserFollow userFollow) {
		return DataMessage.createSuccessMsg(userFollowService.updateUserFollow(userFollow), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findUserFollowById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(userFollowService.findUserFollowById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findUserFollowList(@RequestBody UserFollowVo userFollowVo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(userFollowService.findUserFollowList(userFollowVo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteUserFollowById(@PathVariable("id") String id) {
		userFollowService.deleteUserFollowById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
