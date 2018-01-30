package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.CarouselFigure;
import cn.aldd.vape.user.micro.service.CarouselFigureService;

@RestController
@RequestMapping(value = "/carouselFigure/micro")
public class CarouselFigureMicroController {
	@Autowired
	private CarouselFigureService carouselFigureService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addCarouselFigure(@RequestBody CarouselFigure carouselFigure) {
		return DataMessage.createSuccessMsg(carouselFigureService.addCarouselFigure(carouselFigure), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateCarouselFigure(@RequestBody CarouselFigure carouselFigure) {
		return DataMessage.createSuccessMsg(carouselFigureService.updateCarouselFigure(carouselFigure), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findCarouselFigureById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(carouselFigureService.findCarouselFigureById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{pageNum}/{pageSize}")
	public DataMessage findCarouselFigureList(/*@RequestBody CarouselFigureVo carouselFigureVo,*/ @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(carouselFigureService.findCarouselFigureList(null, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteCarouselFigureById(@PathVariable("id") String id) {
		carouselFigureService.deleteCarouselFigureById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
