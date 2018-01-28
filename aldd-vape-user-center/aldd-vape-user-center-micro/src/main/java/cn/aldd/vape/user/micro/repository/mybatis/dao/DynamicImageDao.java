package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.DynamicImageVo;

@Mapper
public interface DynamicImageDao {

	DynamicImageVo findDynamicImageById(@Param("id") String id);

	List<DynamicImageVo> findDynamicImageList(@Param("entity") DynamicImageVo dynamicImageVo);

}
