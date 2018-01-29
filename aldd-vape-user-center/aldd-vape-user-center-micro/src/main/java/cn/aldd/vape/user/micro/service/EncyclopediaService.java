package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.Encyclopedia;
import cn.aldd.vape.user.micro.vo.EncyclopediaVo;

public interface EncyclopediaService {

	Encyclopedia addEncyclopedia(Encyclopedia encyclopedia);

	Encyclopedia updateEncyclopedia(Encyclopedia encyclopedia);

	EncyclopediaVo findEncyclopediaById(String id);

	PageInfo<EncyclopediaVo> findEncyclopediaList(EncyclopediaVo encyclopediaVo, Integer pageNum, Integer pageSize);

	void deleteEncyclopediaById(String id);

}
