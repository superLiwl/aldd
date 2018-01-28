package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.aldd.vape.user.micro.domain.EncyclopediaImage;
import cn.aldd.vape.user.micro.repository.jpa.EncyclopediaImageRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.EncyclopediaImageDao;
import cn.aldd.vape.user.micro.service.EncyclopediaImageService;
import cn.aldd.vape.user.micro.vo.EncyclopediaImageVo;

@Service("encyclopediaImageService")
public class EncyclopediaImageServiceImpl implements EncyclopediaImageService {

	@Autowired
	private EncyclopediaImageDao encyclopediaImageDao;
	@Autowired
	private EncyclopediaImageRepository encyclopediaImageRepository;

	@Override
	public EncyclopediaImage addEncyclopediaImage(EncyclopediaImage encyclopediaImage) {
		encyclopediaImage.setCreateTime(new Date());
		encyclopediaImage = encyclopediaImageRepository.save(encyclopediaImage);
		return encyclopediaImage;
	}

	@Override
	public EncyclopediaImage updateEncyclopediaImage(EncyclopediaImage encyclopediaImage) {
		encyclopediaImage = encyclopediaImageRepository.save(encyclopediaImage);
		return encyclopediaImage;
	}

	@Override
	public EncyclopediaImageVo findEncyclopediaImageById(String id) {
		return encyclopediaImageDao.findEncyclopediaImageById(id);
	}

	@Override
	public List<EncyclopediaImageVo> findEncyclopediaImageList(EncyclopediaImageVo encyclopediaImageVo) {
		PageHelper.startPage(encyclopediaImageVo.getPageNum(), encyclopediaImageVo.getPageSize());
		List<EncyclopediaImageVo> result = encyclopediaImageDao.findEncyclopediaImageList(encyclopediaImageVo);
		return result;
	}

	@Override
	public void deleteEncyclopediaImageById(String id) {
		encyclopediaImageRepository.delete(id);
	}

}