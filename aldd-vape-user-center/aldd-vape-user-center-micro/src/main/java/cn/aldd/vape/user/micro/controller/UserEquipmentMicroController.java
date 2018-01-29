package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.UserEquipment;
import cn.aldd.vape.user.micro.service.UserEquipmentService;
import cn.aldd.vape.user.micro.vo.UserEquipmentVo;

@RestController
@RequestMapping(value = "/userEquipment/micro")
public class UserEquipmentMicroController {
	@Autowired
	private UserEquipmentService userEquipmentService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addUserEquipment(@RequestBody UserEquipment userEquipment) {
		return DataMessage.createSuccessMsg(userEquipmentService.addUserEquipment(userEquipment), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateUserEquipment(@RequestBody UserEquipment userEquipment) {
		return DataMessage.createSuccessMsg(userEquipmentService.updateUserEquipment(userEquipment), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findUserEquipmentById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(userEquipmentService.findUserEquipmentById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findUserEquipmentList(@RequestBody UserEquipmentVo userEquipmentVo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(userEquipmentService.findUserEquipmentList(userEquipmentVo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteUserEquipmentById(@PathVariable("id") String id) {
		userEquipmentService.deleteUserEquipmentById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
