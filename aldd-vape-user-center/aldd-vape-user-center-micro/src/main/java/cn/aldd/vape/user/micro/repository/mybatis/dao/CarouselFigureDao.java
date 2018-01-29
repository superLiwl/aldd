package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.CarouselFigureVo;

@Mapper
public interface CarouselFigureDao {

	CarouselFigureVo findCarouselFigureById(@Param("id") String id);

	List<CarouselFigureVo> findCarouselFigureList(@Param("entity") CarouselFigureVo carouselFigureVo);

}
