package cn.aldd.vape.user.micro.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.aldd.vape.user.micro.domain.DynamicImage;

public interface DynamicImageRepository extends JpaRepository<DynamicImage, String> {

}