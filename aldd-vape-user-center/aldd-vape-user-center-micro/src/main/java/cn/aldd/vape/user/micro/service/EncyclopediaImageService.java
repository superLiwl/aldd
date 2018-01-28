package cn.aldd.vape.user.micro.service;

import java.util.List;

import cn.aldd.vape.user.micro.domain.EncyclopediaImage;
import cn.aldd.vape.user.micro.vo.EncyclopediaImageVo;


public interface EncyclopediaImageService {
	

	EncyclopediaImage addEncyclopediaImage(EncyclopediaImage encyclopediaImage);

	EncyclopediaImage updateEncyclopediaImage(EncyclopediaImage encyclopediaImage);

	EncyclopediaImageVo findEncyclopediaImageById(String id);

	List<EncyclopediaImageVo> findEncyclopediaImageList(EncyclopediaImageVo encyclopediaImageVo);

	void deleteEncyclopediaImageById(String id);
	
}
