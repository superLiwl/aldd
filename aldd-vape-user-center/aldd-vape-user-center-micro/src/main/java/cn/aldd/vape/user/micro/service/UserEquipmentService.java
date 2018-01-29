package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.UserEquipment;
import cn.aldd.vape.user.micro.vo.UserEquipmentVo;

public interface UserEquipmentService {

	UserEquipment addUserEquipment(UserEquipment userEquipment);

	UserEquipment updateUserEquipment(UserEquipment userEquipment);

	UserEquipmentVo findUserEquipmentById(String id);

	PageInfo<UserEquipmentVo> findUserEquipmentList(UserEquipmentVo userEquipmentVo, Integer pageNum, Integer pageSize);

	void deleteUserEquipmentById(String id);

}
