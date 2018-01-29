package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.CarouselFigure;
import cn.aldd.vape.user.micro.vo.CarouselFigureVo;

public interface CarouselFigureService {

	CarouselFigure addCarouselFigure(CarouselFigure carouselFigure);

	CarouselFigure updateCarouselFigure(CarouselFigure carouselFigure);

	CarouselFigureVo findCarouselFigureById(String id);

	PageInfo<CarouselFigureVo> findCarouselFigureList(CarouselFigureVo carouselFigureVo, Integer pageNum, Integer pageSize);

	void deleteCarouselFigureById(String id);

}
