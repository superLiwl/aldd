package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.UserSignature;
import cn.aldd.vape.user.micro.repository.jpa.UserSignatureRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.UserSignatureDao;
import cn.aldd.vape.user.micro.service.UserSignatureService;
import cn.aldd.vape.user.micro.vo.UserSignatureVo;

@Service("userSignatureService")
public class UserSignatureServiceImpl implements UserSignatureService {

	@Autowired
	private UserSignatureDao userSignatureDao;
	@Autowired
	private UserSignatureRepository userSignatureRepository;

	@Override
	public UserSignature addUserSignature(UserSignature userSignature) {
		userSignature.setCreateTime(new Date());
		userSignature = userSignatureRepository.save(userSignature);
		return userSignature;
	}

	@Override
	public UserSignature updateUserSignature(UserSignature userSignature) {
		UserSignature oldUSser = userSignatureRepository.findOne(userSignature.getId());
		userSignature.setCreateTime(oldUSser.getCreateTime());
		userSignature = userSignatureRepository.save(userSignature);
		return userSignature;
	}

	@Override
	public UserSignatureVo findUserSignatureById(String id) {
		return userSignatureDao.findUserSignatureById(id);
	}

	@Override
	public PageInfo<UserSignatureVo> findUserSignatureList(UserSignatureVo userSignatureVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<UserSignatureVo> result = new PageInfo<UserSignatureVo>(userSignatureDao.findUserSignatureList(userSignatureVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		return result;
	}

	@Override
	public void deleteUserSignatureById(String id) {
		userSignatureRepository.delete(id);
	}

}