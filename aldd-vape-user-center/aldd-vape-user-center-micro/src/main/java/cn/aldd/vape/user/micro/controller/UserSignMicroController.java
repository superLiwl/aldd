package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.UserSign;
import cn.aldd.vape.user.micro.service.UserSignService;
import cn.aldd.vape.user.micro.vo.UserSignVo;

@RestController
@RequestMapping(value = "/userSign/micro")
public class UserSignMicroController {
	@Autowired
	private UserSignService userSignService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addUserSign(@RequestBody UserSign userSign) {
		return DataMessage.createSuccessMsg(userSignService.addUserSign(userSign), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateUserSign(@RequestBody UserSign userSign) {
		return DataMessage.createSuccessMsg(userSignService.updateUserSign(userSign), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findUserSignById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(userSignService.findUserSignById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findUserSignList(@RequestBody UserSignVo userSignVo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(userSignService.findUserSignList(userSignVo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteUserSignById(@PathVariable("id") String id) {
		userSignService.deleteUserSignById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
