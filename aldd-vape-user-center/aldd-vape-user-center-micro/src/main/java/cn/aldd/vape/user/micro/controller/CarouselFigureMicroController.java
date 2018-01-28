package cn.aldd.vape.user.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.user.micro.domain.CarouselFigure;
import cn.aldd.vape.user.micro.service.CarouselFigureService;
import cn.aldd.vape.user.micro.vo.CarouselFigureVo;

@RestController
public class CarouselFigureMicroController {
	@Autowired
	private CarouselFigureService carouselFigureService;

	@RequestMapping(method = RequestMethod.POST, value = "/carouselFigure/micro/addCarouselFigure")
	public CarouselFigure addCarouselFigure(@RequestBody CarouselFigure carouselFigure) {
		return carouselFigureService.addCarouselFigure(carouselFigure);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/carouselFigure/micro/updateCarouselFigure")
	public CarouselFigure updateCarouselFigure(@RequestBody CarouselFigure carouselFigure) {
		return carouselFigureService.updateCarouselFigure(carouselFigure);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/carouselFigure/micro/{id}")
	public CarouselFigureVo findCarouselFigureById(@PathVariable("id") String id) {
		return carouselFigureService.findCarouselFigureById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/carouselFigure/micro/findCarouselFigureList")
	public List<CarouselFigureVo> findCarouselFigureList(@RequestBody CarouselFigureVo carouselFigureVo) {
		return carouselFigureService.findCarouselFigureList(carouselFigureVo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/carouselFigure/micro/{id}")
	public void deleteCarouselFigureById(@PathVariable("id") String id) {
		carouselFigureService.deleteCarouselFigureById(id);
	}

}
