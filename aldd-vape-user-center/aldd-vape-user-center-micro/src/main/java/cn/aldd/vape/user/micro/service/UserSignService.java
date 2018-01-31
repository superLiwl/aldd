package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.UserSign;
import cn.aldd.vape.user.micro.vo.UserSignVo;

public interface UserSignService {

	UserSign addUserSign(UserSign userSign);

	UserSign updateUserSign(UserSign userSign);

	UserSignVo findUserSignById(String id);

	PageInfo<UserSignVo> findUserSignList(UserSignVo userSignVo, Integer pageNum, Integer pageSize);

	void deleteUserSignById(String id);

}
