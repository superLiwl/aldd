package cn.aldd.vape.user.micro.service;

import java.util.List;

import cn.aldd.vape.user.micro.domain.Encyclopedia;
import cn.aldd.vape.user.micro.vo.EncyclopediaVo;


public interface EncyclopediaService {
	

	Encyclopedia addEncyclopedia(Encyclopedia encyclopedia);

	Encyclopedia updateEncyclopedia(Encyclopedia encyclopedia);

	EncyclopediaVo findEncyclopediaById(String id);

	List<EncyclopediaVo> findEncyclopediaList(EncyclopediaVo encyclopediaVo);

	void deleteEncyclopediaById(String id);
	
}
