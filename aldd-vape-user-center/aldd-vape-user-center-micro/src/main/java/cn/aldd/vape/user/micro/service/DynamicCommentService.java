package cn.aldd.vape.user.micro.service;

import java.util.List;

import cn.aldd.vape.user.micro.domain.DynamicComment;
import cn.aldd.vape.user.micro.vo.DynamicCommentVo;


public interface DynamicCommentService {
	

	DynamicComment addDynamicComment(DynamicComment dynamicComment);

	DynamicComment updateDynamicComment(DynamicComment dynamicComment);

	DynamicCommentVo findDynamicCommentById(String id);

	List<DynamicCommentVo> findDynamicCommentList(DynamicCommentVo dynamicCommentVo);

	void deleteDynamicCommentById(String id);
	
}
