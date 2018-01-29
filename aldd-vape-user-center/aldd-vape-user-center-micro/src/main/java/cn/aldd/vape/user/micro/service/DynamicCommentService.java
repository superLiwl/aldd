package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.DynamicComment;
import cn.aldd.vape.user.micro.vo.DynamicCommentVo;

public interface DynamicCommentService {

	DynamicComment addDynamicComment(DynamicComment dynamicComment);

	DynamicComment updateDynamicComment(DynamicComment dynamicComment);

	DynamicCommentVo findDynamicCommentById(String id);

	PageInfo<DynamicCommentVo> findDynamicCommentList(DynamicCommentVo dynamicCommentVo, Integer pageNum, Integer pageSize);

	void deleteDynamicCommentById(String id);

}
