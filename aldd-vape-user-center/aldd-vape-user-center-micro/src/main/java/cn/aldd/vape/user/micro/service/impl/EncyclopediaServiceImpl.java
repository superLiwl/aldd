package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.Encyclopedia;
import cn.aldd.vape.user.micro.repository.jpa.EncyclopediaRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.EncyclopediaDao;
import cn.aldd.vape.user.micro.service.EncyclopediaService;
import cn.aldd.vape.user.micro.vo.EncyclopediaVo;

@Service("encyclopediaService")
public class EncyclopediaServiceImpl implements EncyclopediaService {

	@Autowired
	private EncyclopediaDao encyclopediaDao;
	@Autowired
	private EncyclopediaRepository encyclopediaRepository;

	@Override
	public Encyclopedia addEncyclopedia(Encyclopedia encyclopedia) {
		encyclopedia.setCreateTime(new Date());
		encyclopedia = encyclopediaRepository.save(encyclopedia);
		return encyclopedia;
	}

	@Override
	public Encyclopedia updateEncyclopedia(Encyclopedia encyclopedia) {
		Encyclopedia oldUSser = encyclopediaRepository.findOne(encyclopedia.getId());
		encyclopedia.setCreateTime(oldUSser.getCreateTime());
		encyclopedia = encyclopediaRepository.save(encyclopedia);
		return encyclopedia;
	}

	@Override
	public EncyclopediaVo findEncyclopediaById(String id) {
		return encyclopediaDao.findEncyclopediaById(id);
	}

	@Override
	public PageInfo<EncyclopediaVo> findEncyclopediaList(EncyclopediaVo encyclopediaVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<EncyclopediaVo> result = new PageInfo<EncyclopediaVo>(encyclopediaDao.findEncyclopediaList(encyclopediaVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		return result;
	}

	@Override
	public void deleteEncyclopediaById(String id) {
		encyclopediaRepository.delete(id);
	}

}