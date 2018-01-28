package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

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
		encyclopedia = encyclopediaRepository.save(encyclopedia);
		return encyclopedia;
	}

	@Override
	public EncyclopediaVo findEncyclopediaById(String id) {
		return encyclopediaDao.findEncyclopediaById(id);
	}

	@Override
	public List<EncyclopediaVo> findEncyclopediaList(EncyclopediaVo encyclopediaVo) {
		PageHelper.startPage(encyclopediaVo.getPageNum(), encyclopediaVo.getPageSize());
		List<EncyclopediaVo> result = encyclopediaDao.findEncyclopediaList(encyclopediaVo);
		return result;
	}

	@Override
	public void deleteEncyclopediaById(String id) {
		encyclopediaRepository.delete(id);
	}

}