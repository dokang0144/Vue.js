package com.example.vuebackboard.services;

import com.example.vuebackboard.entity.CommentEntity;
import com.example.vuebackboard.entity.CommentRepository;
import com.example.vuebackboard.model.SearchCondition;
import com.example.vuebackboard.web.dtos.CommentDto;
import com.example.vuebackboard.model.Header;
import com.example.vuebackboard.model.Pagination;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
                    .c_idx(entity.getC_idx())
                    .user_id(entity.getUser_id())
                    .comment(entity.getComment())
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
                .c_idx(entity.getC_idx())
                .user_id(entity.getUser_id())
                .comment(entity.getComment())
                .build();
    }

    /**
     * 게시글 등록
     */
    public CommentEntity create(CommentDto commentDto) {
        CommentEntity entity = CommentEntity.builder()
                .idx(commentDto.getIdx())
                .user_id(commentDto.getUser_id())
                .comment(commentDto.getComment())
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