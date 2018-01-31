package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.UserSignVo;

@Mapper
public interface UserSignDao {

	UserSignVo findUserSignById(@Param("id") String id);

	List<UserSignVo> findUserSignList(@Param("entity") UserSignVo userSignVo);

}
