package com.example.vuebackboard.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SignRepository extends JpaRepository<SignEntity, Long> {
    boolean existsByUserId(String userId);
}