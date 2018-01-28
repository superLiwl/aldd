package cn.aldd.vape.user.micro.service;

import java.util.List;

import cn.aldd.vape.user.micro.domain.Equipment;
import cn.aldd.vape.user.micro.vo.EquipmentVo;


public interface EquipmentService {
	

	Equipment addEquipment(Equipment equipment);

	Equipment updateEquipment(Equipment equipment);

	EquipmentVo findEquipmentById(String id);

	List<EquipmentVo> findEquipmentList(EquipmentVo equipmentVo);

	void deleteEquipmentById(String id);
	
}
