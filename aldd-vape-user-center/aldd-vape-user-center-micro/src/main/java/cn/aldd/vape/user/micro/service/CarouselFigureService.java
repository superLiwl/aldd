package cn.aldd.vape.user.micro.service;

import java.util.List;

import cn.aldd.vape.user.micro.domain.CarouselFigure;
import cn.aldd.vape.user.micro.vo.CarouselFigureVo;


public interface CarouselFigureService {
	

	CarouselFigure addCarouselFigure(CarouselFigure carouselFigure);

	CarouselFigure updateCarouselFigure(CarouselFigure carouselFigure);

	CarouselFigureVo findCarouselFigureById(String id);

	List<CarouselFigureVo> findCarouselFigureList(CarouselFigureVo carouselFigureVo);

	void deleteCarouselFigureById(String id);
	
}
