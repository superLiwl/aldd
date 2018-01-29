package cn.aldd.vape.user.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.UserEquipment;
import cn.aldd.vape.user.micro.repository.jpa.UserEquipmentRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.UserEquipmentDao;
import cn.aldd.vape.user.micro.service.UserEquipmentService;
import cn.aldd.vape.user.micro.vo.UserEquipmentVo;

@Service("userEquipmentService")
public class UserEquipmentServiceImpl implements UserEquipmentService {

	@Autowired
	private UserEquipmentDao userEquipmentDao;
	@Autowired
	private UserEquipmentRepository userEquipmentRepository;

	@Override
	public UserEquipment addUserEquipment(UserEquipment userEquipment) {
		userEquipment.setCreateTime(new Date());
		userEquipment = userEquipmentRepository.save(userEquipment);
		return userEquipment;
	}

	@Override
	public UserEquipment updateUserEquipment(UserEquipment userEquipment) {
		UserEquipment oldUSser = userEquipmentRepository.findOne(userEquipment.getId());
		userEquipment.setCreateTime(oldUSser.getCreateTime());
		userEquipment = userEquipmentRepository.save(userEquipment);
		return userEquipment;
	}

	@Override
	public UserEquipmentVo findUserEquipmentById(String id) {
		return userEquipmentDao.findUserEquipmentById(id);
	}

	@Override
	public PageInfo<UserEquipmentVo> findUserEquipmentList(UserEquipmentVo userEquipmentVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<UserEquipmentVo> result = new PageInfo<UserEquipmentVo>(userEquipmentDao.findUserEquipmentList(userEquipmentVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		return result;
	}

	@Override
	public void deleteUserEquipmentById(String id) {
		userEquipmentRepository.delete(id);
	}

}