package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.aldd.vape.user.micro.domain.DynamicComment;
import cn.aldd.vape.user.micro.repository.jpa.DynamicCommentRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.DynamicCommentDao;
import cn.aldd.vape.user.micro.service.DynamicCommentService;
import cn.aldd.vape.user.micro.vo.DynamicCommentVo;

@Service("dynamicCommentService")
public class DynamicCommentServiceImpl implements DynamicCommentService {

	@Autowired
	private DynamicCommentDao dynamicCommentDao;
	@Autowired
	private DynamicCommentRepository dynamicCommentRepository;

	@Override
	public DynamicComment addDynamicComment(DynamicComment dynamicComment) {
		dynamicComment.setCreateTime(new Date());
		dynamicComment = dynamicCommentRepository.save(dynamicComment);
		return dynamicComment;
	}

	@Override
	public DynamicComment updateDynamicComment(DynamicComment dynamicComment) {
		dynamicComment = dynamicCommentRepository.save(dynamicComment);
		return dynamicComment;
	}

	@Override
	public DynamicCommentVo findDynamicCommentById(String id) {
		return dynamicCommentDao.findDynamicCommentById(id);
	}

	@Override
	public List<DynamicCommentVo> findDynamicCommentList(DynamicCommentVo dynamicCommentVo) {
		PageHelper.startPage(dynamicCommentVo.getPageNum(), dynamicCommentVo.getPageSize());
		List<DynamicCommentVo> result = dynamicCommentDao.findDynamicCommentList(dynamicCommentVo);
		return result;
	}

	@Override
	public void deleteDynamicCommentById(String id) {
		dynamicCommentRepository.delete(id);
	}

}