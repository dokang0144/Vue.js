package com.example.vuebackboard.services;

import com.example.vuebackboard.entity.CommentEntity;
import com.example.vuebackboard.entity.CommentRepository;
import com.example.vuebackboard.web.dtos.CommentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    /**
     * 게시글 목록 가져오기
     */
    public List<CommentDto> getCommentList() {
        List<CommentEntity> commentEntities = commentRepository.findAll();
        List<CommentDto> dtos = new ArrayList<>();

        for (CommentEntity entity : commentEntities) {
            CommentDto dto = CommentDto.builder()
                    .idx(entity.getIdx())
                    .userName(entity.getUserName())
                    .comment(entity.getComment())
                    .board(entity.getBoard())
                    .build();

            dtos.add(dto);
        }

        return dtos;
    }

    /**
     * 게시글 가져오기
     */
    public CommentDto getComment(Long id) {
        CommentEntity entity = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return CommentDto.builder()
                .idx(entity.getIdx())
                .userName(entity.getUserName())
                .comment(entity.getComment())
                .board(entity.getBoard())
                .build();
    }

    /**
     * 게시글 등록
     */
    public CommentEntity create(CommentDto commentDto) {
        CommentEntity entity = CommentEntity.builder()
                .userName(commentDto.getUserName())
                .comment(commentDto.getComment())
                .board(commentDto.getBoard())
                .build();
        return commentRepository.save(entity);
    }

    /**
     * 게시글 삭제
     */
    public void delete(Long id) {
        CommentEntity entity = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        commentRepository.delete(entity);
    }
}