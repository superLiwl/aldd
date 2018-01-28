package cn.aldd.vape.user.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.user.micro.domain.Equipment;
import cn.aldd.vape.user.micro.service.EquipmentService;
import cn.aldd.vape.user.micro.vo.EquipmentVo;

@RestController
public class EquipmentMicroController {
	@Autowired
	private EquipmentService equipmentService;

	@RequestMapping(method = RequestMethod.POST, value = "/equipment/micro/addEquipment")
	public Equipment addEquipment(@RequestBody Equipment equipment) {
		return equipmentService.addEquipment(equipment);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/equipment/micro/updateEquipment")
	public Equipment updateEquipment(@RequestBody Equipment equipment) {
		return equipmentService.updateEquipment(equipment);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/equipment/micro/{id}")
	public EquipmentVo findEquipmentById(@PathVariable("id") String id) {
		return equipmentService.findEquipmentById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/equipment/micro/findEquipmentList")
	public List<EquipmentVo> findEquipmentList(@RequestBody EquipmentVo equipmentVo) {
		return equipmentService.findEquipmentList(equipmentVo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/equipment/micro/{id}")
	public void deleteEquipmentById(@PathVariable("id") String id) {
		equipmentService.deleteEquipmentById(id);
	}

}
