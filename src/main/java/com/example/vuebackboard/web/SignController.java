package com.example.vuebackboard.web;

import com.example.vuebackboard.entity.CommentEntity;
import com.example.vuebackboard.entity.SignEntity;
import com.example.vuebackboard.services.CommentService;
import com.example.vuebackboard.services.SignService;
import com.example.vuebackboard.web.dtos.CommentDto;
import com.example.vuebackboard.web.dtos.SignDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/sign")
public class SignController {
    private final SignService signService;

    @PostMapping("/up")
    public SignEntity create(@RequestBody SignDto signDto) {
        return signService.create(signDto);
    }
}