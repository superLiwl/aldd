package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
		CarouselFigure oldUSser = carouselFigureRepository.findOne(carouselFigure.getId());
		carouselFigure.setCreateTime(oldUSser.getCreateTime());
		carouselFigure = carouselFigureRepository.save(carouselFigure);
		return carouselFigure;
	}

	@Override
	public CarouselFigureVo findCarouselFigureById(String id) {
		return carouselFigureDao.findCarouselFigureById(id);
	}

	@Override
	public PageInfo<CarouselFigureVo> findCarouselFigureList(CarouselFigureVo carouselFigureVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<CarouselFigureVo> result = new PageInfo<CarouselFigureVo>(carouselFigureDao.findCarouselFigureList(carouselFigureVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		return result;
	}

	@Override
	public void deleteCarouselFigureById(String id) {
		carouselFigureRepository.delete(id);
	}

}