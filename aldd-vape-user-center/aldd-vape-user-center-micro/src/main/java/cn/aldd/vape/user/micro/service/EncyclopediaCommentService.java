package cn.aldd.vape.user.micro.service;

import java.util.List;

import cn.aldd.vape.user.micro.domain.EncyclopediaComment;
import cn.aldd.vape.user.micro.vo.EncyclopediaCommentVo;


public interface EncyclopediaCommentService {
	

	EncyclopediaComment addEncyclopediaComment(EncyclopediaComment encyclopediaComment);

	EncyclopediaComment updateEncyclopediaComment(EncyclopediaComment encyclopediaComment);

	EncyclopediaCommentVo findEncyclopediaCommentById(String id);

	List<EncyclopediaCommentVo> findEncyclopediaCommentList(EncyclopediaCommentVo encyclopediaCommentVo);

	void deleteEncyclopediaCommentById(String id);
	
}
