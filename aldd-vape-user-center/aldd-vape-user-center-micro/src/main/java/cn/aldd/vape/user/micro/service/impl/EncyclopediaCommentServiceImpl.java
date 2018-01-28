package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.aldd.vape.user.micro.domain.EncyclopediaComment;
import cn.aldd.vape.user.micro.repository.jpa.EncyclopediaCommentRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.EncyclopediaCommentDao;
import cn.aldd.vape.user.micro.service.EncyclopediaCommentService;
import cn.aldd.vape.user.micro.vo.EncyclopediaCommentVo;

@Service("encyclopediaCommentService")
public class EncyclopediaCommentServiceImpl implements EncyclopediaCommentService {

	@Autowired
	private EncyclopediaCommentDao encyclopediaCommentDao;
	@Autowired
	private EncyclopediaCommentRepository encyclopediaCommentRepository;

	@Override
	public EncyclopediaComment addEncyclopediaComment(EncyclopediaComment encyclopediaComment) {
		encyclopediaComment.setCreateTime(new Date());
		encyclopediaComment = encyclopediaCommentRepository.save(encyclopediaComment);
		return encyclopediaComment;
	}

	@Override
	public EncyclopediaComment updateEncyclopediaComment(EncyclopediaComment encyclopediaComment) {
		encyclopediaComment = encyclopediaCommentRepository.save(encyclopediaComment);
		return encyclopediaComment;
	}

	@Override
	public EncyclopediaCommentVo findEncyclopediaCommentById(String id) {
		return encyclopediaCommentDao.findEncyclopediaCommentById(id);
	}

	@Override
	public List<EncyclopediaCommentVo> findEncyclopediaCommentList(EncyclopediaCommentVo encyclopediaCommentVo) {
		PageHelper.startPage(encyclopediaCommentVo.getPageNum(), encyclopediaCommentVo.getPageSize());
		List<EncyclopediaCommentVo> result = encyclopediaCommentDao.findEncyclopediaCommentList(encyclopediaCommentVo);
		return result;
	}

	@Override
	public void deleteEncyclopediaCommentById(String id) {
		encyclopediaCommentRepository.delete(id);
	}

}