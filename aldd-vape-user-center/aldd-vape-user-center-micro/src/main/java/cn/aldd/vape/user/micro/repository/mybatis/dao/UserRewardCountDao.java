package cn.aldd.vape.user.micro.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.aldd.vape.user.micro.vo.UserRewardCountVo;

@Mapper
public interface UserRewardCountDao {

	UserRewardCountVo findUserRewardCountById(@Param("id") String id);

	List<UserRewardCountVo> findUserRewardCountList(@Param("entity") UserRewardCountVo userRewardCountVo);

}
