package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.UserSignatureVo;

@Mapper
public interface UserSignatureDao {

	UserSignatureVo findUserSignatureById(@Param("id") String id);

	List<UserSignatureVo> findUserSignatureList(@Param("entity") UserSignatureVo userSignatureVo);

}
