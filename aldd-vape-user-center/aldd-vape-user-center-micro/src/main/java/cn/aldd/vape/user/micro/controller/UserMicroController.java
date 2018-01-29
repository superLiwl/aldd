package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.User;
import cn.aldd.vape.user.micro.service.UserService;
import cn.aldd.vape.user.micro.vo.UserVo;

@RestController
@RequestMapping(value = "/user/micro")
public class UserMicroController {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addUser(@RequestBody User user) {
		return DataMessage.createSuccessMsg(userService.addUser(user), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateUser(@RequestBody User user) {
		return DataMessage.createSuccessMsg(userService.updateUser(user), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findUserById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(userService.findUserById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findUserList(@RequestBody UserVo userVo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(userService.findUserList(userVo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteUserById(@PathVariable("id") String id) {
		userService.deleteUserById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
