package com.example.vuebackboard.services;

import com.example.vuebackboard.entity.CommentEntity;
import com.example.vuebackboard.entity.CommentRepository;
import com.example.vuebackboard.entity.SignEntity;
import com.example.vuebackboard.entity.SignRepository;
import com.example.vuebackboard.web.dtos.CommentDto;
import com.example.vuebackboard.web.dtos.SignDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignService {
    @Autowired
    private SignRepository signRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public SignEntity create(SignDto signDto) {
        try {
            String encodedPassword = bCryptPasswordEncoder.encode(signDto.getUserPw());
            SignEntity entity = SignEntity.builder()
                    .userId(signDto.getUserId())
                    .userPw(encodedPassword)
                    .userName(signDto.getUserName())
                    .build();
            return signRepository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("회원가입 도중 오류가 발생했습니다.");
        }
    }
}