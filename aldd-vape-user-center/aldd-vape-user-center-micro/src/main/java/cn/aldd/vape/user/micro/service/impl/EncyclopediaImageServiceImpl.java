package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
		EncyclopediaImage oldUSser = encyclopediaImageRepository.findOne(encyclopediaImage.getId());
		encyclopediaImage.setCreateTime(oldUSser.getCreateTime());
		encyclopediaImage = encyclopediaImageRepository.save(encyclopediaImage);
		return encyclopediaImage;
	}

	@Override
	public EncyclopediaImageVo findEncyclopediaImageById(String id) {
		return encyclopediaImageDao.findEncyclopediaImageById(id);
	}

	@Override
	public PageInfo<EncyclopediaImageVo> findEncyclopediaImageList(EncyclopediaImageVo encyclopediaImageVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<EncyclopediaImageVo> result = new PageInfo<EncyclopediaImageVo>(encyclopediaImageDao.findEncyclopediaImageList(encyclopediaImageVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		return result;
	}

	@Override
	public void deleteEncyclopediaImageById(String id) {
		encyclopediaImageRepository.delete(id);
	}

}