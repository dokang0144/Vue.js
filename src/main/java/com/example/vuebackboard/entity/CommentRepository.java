package com.example.vuebackboard.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}