package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.EncyclopediaImageVo;

@Mapper
public interface EncyclopediaImageDao {

	EncyclopediaImageVo findEncyclopediaImageById(@Param("id") String id);

	List<EncyclopediaImageVo> findEncyclopediaImageList(@Param("entity") EncyclopediaImageVo encyclopediaImageVo);

}
