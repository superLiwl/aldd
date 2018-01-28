package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.aldd.vape.user.micro.domain.Equipment;
import cn.aldd.vape.user.micro.repository.jpa.EquipmentRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.EquipmentDao;
import cn.aldd.vape.user.micro.service.EquipmentService;
import cn.aldd.vape.user.micro.vo.EquipmentVo;

@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private EquipmentDao equipmentDao;
	@Autowired
	private EquipmentRepository equipmentRepository;

	@Override
	public Equipment addEquipment(Equipment equipment) {
		equipment.setCreateTime(new Date());
		equipment = equipmentRepository.save(equipment);
		return equipment;
	}

	@Override
	public Equipment updateEquipment(Equipment equipment) {
		equipment = equipmentRepository.save(equipment);
		return equipment;
	}

	@Override
	public EquipmentVo findEquipmentById(String id) {
		return equipmentDao.findEquipmentById(id);
	}

	@Override
	public List<EquipmentVo> findEquipmentList(EquipmentVo equipmentVo) {
		PageHelper.startPage(equipmentVo.getPageNum(), equipmentVo.getPageSize());
		List<EquipmentVo> result = equipmentDao.findEquipmentList(equipmentVo);
		return result;
	}

	@Override
	public void deleteEquipmentById(String id) {
		equipmentRepository.delete(id);
	}

}