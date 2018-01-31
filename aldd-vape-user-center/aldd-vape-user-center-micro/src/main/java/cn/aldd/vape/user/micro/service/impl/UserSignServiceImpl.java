package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.UserSign;
import cn.aldd.vape.user.micro.repository.jpa.UserSignRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.UserSignDao;
import cn.aldd.vape.user.micro.service.UserSignService;
import cn.aldd.vape.user.micro.vo.UserSignVo;

@Service("userSignService")
public class UserSignServiceImpl implements UserSignService {

	@Autowired
	private UserSignDao userSignDao;
	@Autowired
	private UserSignRepository userSignRepository;

	@Override
	public UserSign addUserSign(UserSign userSign) {
		//签到时候增加打赏次数 -- 并且判断今天是否已经签到， 并且判断连续签到几天
		
		userSign.setCreateTime(new Date());
		userSign = userSignRepository.save(userSign);
		return userSign;
	}

	@Override
	public UserSign updateUserSign(UserSign userSign) {
		UserSign oldUSser = userSignRepository.findOne(userSign.getId());
		userSign.setCreateTime(oldUSser.getCreateTime());
		userSign = userSignRepository.save(userSign);
		return userSign;
	}

	@Override
	public UserSignVo findUserSignById(String id) {
		return userSignDao.findUserSignById(id);
	}

	@Override
	public PageInfo<UserSignVo> findUserSignList(UserSignVo userSignVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<UserSignVo> result = new PageInfo<UserSignVo>(userSignDao.findUserSignList(userSignVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		return result;
	}

	@Override
	public void deleteUserSignById(String id) {
		userSignRepository.delete(id);
	}

}