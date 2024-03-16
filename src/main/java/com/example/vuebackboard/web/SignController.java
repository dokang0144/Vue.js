package com.example.vuebackboard.web;

import com.example.vuebackboard.entity.SignEntity;
import com.example.vuebackboard.entity.SignRepository;
import com.example.vuebackboard.services.SignService;
import com.example.vuebackboard.web.dtos.SignDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/sign")
public class SignController {
    private final SignService signService;
    private SignRepository signRepository;

    @PostMapping("/up")
    public ResponseEntity<Object> create(@RequestBody SignDto signDto) {
        try {
            SignEntity entity = signService.create(signDto);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            String errorMessage = "회원가입 도중 오류가 발생했습니다.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PostMapping("/check")
    public ResponseEntity<String> checkDuplication(@RequestBody Map<String, String> requestBody) {
        String userId = requestBody.get("user_id");
        if (signService.isDuplicatedUserId(userId)) {
            return ResponseEntity.badRequest().body("중복된 아이디입니다.");
        } else {
            return ResponseEntity.ok().body("사용 가능한 아이디입니다.");
        }
    }
}