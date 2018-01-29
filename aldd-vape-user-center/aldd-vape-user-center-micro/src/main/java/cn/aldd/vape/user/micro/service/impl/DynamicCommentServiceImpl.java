package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
		DynamicComment oldUSser = dynamicCommentRepository.findOne(dynamicComment.getId());
		dynamicComment.setCreateTime(oldUSser.getCreateTime());
		dynamicComment = dynamicCommentRepository.save(dynamicComment);
		return dynamicComment;
	}

	@Override
	public DynamicCommentVo findDynamicCommentById(String id) {
		return dynamicCommentDao.findDynamicCommentById(id);
	}

	@Override
	public PageInfo<DynamicCommentVo> findDynamicCommentList(DynamicCommentVo dynamicCommentVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<DynamicCommentVo> result = new PageInfo<DynamicCommentVo>(dynamicCommentDao.findDynamicCommentList(dynamicCommentVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		return result;
	}

	@Override
	public void deleteDynamicCommentById(String id) {
		dynamicCommentRepository.delete(id);
	}

}