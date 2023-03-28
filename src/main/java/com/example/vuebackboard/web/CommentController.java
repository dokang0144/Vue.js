package com.example.vuebackboard.web;

import com.example.vuebackboard.entity.CommentEntity;
import com.example.vuebackboard.model.Header;
import com.example.vuebackboard.model.SearchCondition;
import com.example.vuebackboard.services.CommentService;
import com.example.vuebackboard.web.dtos.CommentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comment/list")
    public List<CommentDto> commentList() { return commentService.getCommentList(); }

    @GetMapping("/comment/{id}")
    public CommentDto getComment(@PathVariable Long id) {
        return commentService.getComment(id);
    }

    @PostMapping("/comment")
    public CommentEntity create(@RequestBody CommentDto commentDto) {
        return commentService.create(commentDto);
    }

    @DeleteMapping("/comment/{id}")
    public void delete(@PathVariable Long id) {
        commentService.delete(id);
    }
}