package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.EncyclopediaComment;
import cn.aldd.vape.user.micro.vo.EncyclopediaCommentVo;

public interface EncyclopediaCommentService {

	EncyclopediaComment addEncyclopediaComment(EncyclopediaComment encyclopediaComment);

	EncyclopediaComment updateEncyclopediaComment(EncyclopediaComment encyclopediaComment);

	EncyclopediaCommentVo findEncyclopediaCommentById(String id);

	PageInfo<EncyclopediaCommentVo> findEncyclopediaCommentList(EncyclopediaCommentVo encyclopediaCommentVo, Integer pageNum, Integer pageSize);

	void deleteEncyclopediaCommentById(String id);

}
