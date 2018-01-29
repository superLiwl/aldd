package cn.aldd.vape.user.micro.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.aldd.vape.user.micro.domain.Encyclopedia;

public interface EncyclopediaRepository extends JpaRepository<Encyclopedia, String> {

}