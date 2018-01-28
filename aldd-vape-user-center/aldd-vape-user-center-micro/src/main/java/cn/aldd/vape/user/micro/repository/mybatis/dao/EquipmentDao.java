package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.EquipmentVo;

@Mapper
public interface EquipmentDao {

	EquipmentVo findEquipmentById(@Param("id") String id);

	List<EquipmentVo> findEquipmentList(@Param("entity") EquipmentVo equipmentVo);

}
