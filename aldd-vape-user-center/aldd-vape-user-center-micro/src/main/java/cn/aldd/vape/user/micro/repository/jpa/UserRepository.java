package cn.aldd.vape.user.micro.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.aldd.vape.user.micro.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

	@Modifying
	@Query(value = "UPDATE user SET longitude = ?1 ,latitude = ?2 WHERE open_id = ?3", nativeQuery = true)
	int updateAddress(String longitude, String latitude, String openId);
}