package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.EncyclopediaCommentVo;

@Mapper
public interface EncyclopediaCommentDao {

	EncyclopediaCommentVo findEncyclopediaCommentById(@Param("id") String id);

	List<EncyclopediaCommentVo> findEncyclopediaCommentList(@Param("entity") EncyclopediaCommentVo encyclopediaCommentVo);

}
