package cn.aldd.vape.user.micro.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.aldd.vape.user.micro.domain.DynamicComment;

public interface DynamicCommentRepository extends JpaRepository<DynamicComment, String> {

}