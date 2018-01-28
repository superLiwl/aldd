package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.aldd.vape.user.micro.domain.CarouselFigure;
import cn.aldd.vape.user.micro.repository.jpa.CarouselFigureRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.CarouselFigureDao;
import cn.aldd.vape.user.micro.service.CarouselFigureService;
import cn.aldd.vape.user.micro.vo.CarouselFigureVo;

@Service("carouselFigureService")
public class CarouselFigureServiceImpl implements CarouselFigureService {

	@Autowired
	private CarouselFigureDao carouselFigureDao;
	@Autowired
	private CarouselFigureRepository carouselFigureRepository;

	@Override
	public CarouselFigure addCarouselFigure(CarouselFigure carouselFigure) {
		carouselFigure.setCreateTime(new Date());
		carouselFigure = carouselFigureRepository.save(carouselFigure);
		return carouselFigure;
	}

	@Override
	public CarouselFigure updateCarouselFigure(CarouselFigure carouselFigure) {
		carouselFigure = carouselFigureRepository.save(carouselFigure);
		return carouselFigure;
	}

	@Override
	public CarouselFigureVo findCarouselFigureById(String id) {
		return carouselFigureDao.findCarouselFigureById(id);
	}

	@Override
	public List<CarouselFigureVo> findCarouselFigureList(CarouselFigureVo carouselFigureVo) {
		PageHelper.startPage(carouselFigureVo.getPageNum(), carouselFigureVo.getPageSize());
		List<CarouselFigureVo> result = carouselFigureDao.findCarouselFigureList(carouselFigureVo);
		return result;
	}

	@Override
	public void deleteCarouselFigureById(String id) {
		carouselFigureRepository.delete(id);
	}

}