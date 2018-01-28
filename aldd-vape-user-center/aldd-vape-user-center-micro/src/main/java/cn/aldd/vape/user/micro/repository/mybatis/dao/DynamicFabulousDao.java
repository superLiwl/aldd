package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.DynamicFabulousVo;

@Mapper
public interface DynamicFabulousDao {

	DynamicFabulousVo findDynamicFabulousById(@Param("id") String id);

	List<DynamicFabulousVo> findDynamicFabulousList(@Param("entity") DynamicFabulousVo dynamicFabulousVo);

}
