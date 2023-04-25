package com.example.vuebackboard.services;

import com.example.vuebackboard.entity.RepliesEntity;
import com.example.vuebackboard.entity.RepliesRepository;
import com.example.vuebackboard.web.dtos.RepliesDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RepliesService {

    private final RepliesRepository repliesRepository;

    /**
     * 게시글 목록 가져오기
     */
    public List<RepliesDto> getRepliesList() {
        List<RepliesEntity> repliesEntities = repliesRepository.findAll();
        List<RepliesDto> dtos = new ArrayList<>();

        for (RepliesEntity entity : repliesEntities) {
            RepliesDto dto = RepliesDto.builder()
                    .idx(entity.getIdx())
                    .userName(entity.getUserName())
                    .replies(entity.getReplies())
                    .comment(entity.getComment())
                    .build();

            dtos.add(dto);
        }

        return dtos;
    }

    /**
     * 게시글 가져오기
     */
    public RepliesDto getReplies(Long id) {
        RepliesEntity entity = repliesRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return RepliesDto.builder()
                .idx(entity.getIdx())
                .userName(entity.getUserName())
                .replies(entity.getReplies())
                .comment(entity.getComment())
                .build();
    }

    /**
     * 게시글 등록
     */
    public RepliesEntity create(RepliesDto repliesDto) {
        RepliesEntity entity = RepliesEntity.builder()
                .userName(repliesDto.getUserName())
                .replies(repliesDto.getReplies())
                .comment(repliesDto.getComment())
                .build();
        return repliesRepository.save(entity);
    }

    /**
     * 게시글 삭제
     */
    public void delete(Long id) {
        RepliesEntity entity = repliesRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        repliesRepository.delete(entity);
    }
}