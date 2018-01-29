package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.EncyclopediaImage;
import cn.aldd.vape.user.micro.vo.EncyclopediaImageVo;

public interface EncyclopediaImageService {

	EncyclopediaImage addEncyclopediaImage(EncyclopediaImage encyclopediaImage);

	EncyclopediaImage updateEncyclopediaImage(EncyclopediaImage encyclopediaImage);

	EncyclopediaImageVo findEncyclopediaImageById(String id);

	PageInfo<EncyclopediaImageVo> findEncyclopediaImageList(EncyclopediaImageVo encyclopediaImageVo, Integer pageNum, Integer pageSize);

	void deleteEncyclopediaImageById(String id);

}
