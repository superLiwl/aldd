package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.UserSignature;
import cn.aldd.vape.user.micro.service.UserSignatureService;
import cn.aldd.vape.user.micro.vo.UserSignatureVo;

@RestController
@RequestMapping(value = "/userSignature/micro")
public class UserSignatureMicroController {
	@Autowired
	private UserSignatureService userSignatureService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addUserSignature(@RequestBody UserSignature userSignature) {
		return DataMessage.createSuccessMsg(userSignatureService.addUserSignature(userSignature), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateUserSignature(@RequestBody UserSignature userSignature) {
		return DataMessage.createSuccessMsg(userSignatureService.updateUserSignature(userSignature), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findUserSignatureById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(userSignatureService.findUserSignatureById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findUserSignatureList(@RequestBody UserSignatureVo userSignatureVo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(userSignatureService.findUserSignatureList(userSignatureVo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteUserSignatureById(@PathVariable("id") String id) {
		userSignatureService.deleteUserSignatureById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
