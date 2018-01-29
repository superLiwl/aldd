package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.UserVo;

@Mapper
public interface UserDao {

	UserVo findUserById(@Param("id") String id);

	List<UserVo> findUserList(@Param("entity") UserVo userVo);

	UserVo login(@Param("loginName") String loginName, @Param("password") String password);
}
