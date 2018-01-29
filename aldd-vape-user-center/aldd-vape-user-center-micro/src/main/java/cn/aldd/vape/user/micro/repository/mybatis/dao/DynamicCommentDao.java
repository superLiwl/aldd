package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.DynamicCommentVo;

@Mapper
public interface DynamicCommentDao {

	DynamicCommentVo findDynamicCommentById(@Param("id") String id);

	List<DynamicCommentVo> findDynamicCommentList(@Param("entity") DynamicCommentVo dynamicCommentVo);

}
