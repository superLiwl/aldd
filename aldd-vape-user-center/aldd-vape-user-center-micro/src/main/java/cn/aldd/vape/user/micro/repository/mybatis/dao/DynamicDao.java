package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.DynamicInfosVo;
import cn.aldd.vape.user.micro.vo.DynamicVo;

@Mapper
public interface DynamicDao {

	DynamicVo findDynamicById(@Param("id") String id);

	List<DynamicVo> findDynamicList(@Param("entity") DynamicVo dynamicVo);

	List<DynamicInfosVo> findDynamicInfosById(@Param("id") String id);

	Integer findTodayCountDynamicByUserId(@Param("userId") String userId);

}
