package cn.aldd.vape.user.micro.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.aldd.vape.user.micro.domain.UserEquipment;

public interface UserEquipmentRepository extends JpaRepository<UserEquipment, String> {

}