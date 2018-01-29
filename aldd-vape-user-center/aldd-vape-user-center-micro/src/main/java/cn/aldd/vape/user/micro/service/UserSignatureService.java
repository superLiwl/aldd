package cn.aldd.vape.user.micro.service;

import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.domain.UserSignature;
import cn.aldd.vape.user.micro.vo.UserSignatureVo;

public interface UserSignatureService {

	UserSignature addUserSignature(UserSignature userSignature);

	UserSignature updateUserSignature(UserSignature userSignature);

	UserSignatureVo findUserSignatureById(String id);

	PageInfo<UserSignatureVo> findUserSignatureList(UserSignatureVo userSignatureVo, Integer pageNum, Integer pageSize);

	void deleteUserSignatureById(String id);

}
