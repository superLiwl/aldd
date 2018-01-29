package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.UserEquipmentVo;

@Mapper
public interface UserEquipmentDao {

	UserEquipmentVo findUserEquipmentById(@Param("id") String id);

	List<UserEquipmentVo> findUserEquipmentList(@Param("entity") UserEquipmentVo userEquipmentVo);

}
