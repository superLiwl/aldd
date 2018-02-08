package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.UserRankingVo;
import cn.aldd.vape.user.micro.vo.UserVo;

@Mapper
public interface UserDao {

	UserVo findUserById(@Param("id") String id);

	List<UserVo> findUserList(@Param("entity") UserVo userVo);
	
	List<UserVo> findNearUsers(@Param("userId") String userId);

	List<UserRankingVo> findUserRankingList(@Param("start") String start, @Param("end") String end);

	UserRankingVo findMyRanking(@Param("userId") String userId, @Param("start") String start, @Param("end") String end);

	UserVo login(@Param("loginName") String loginName, @Param("password") String password);
}
