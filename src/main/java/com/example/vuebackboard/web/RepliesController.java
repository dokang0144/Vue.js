package com.example.vuebackboard.web;

import com.example.vuebackboard.entity.RepliesEntity;
import com.example.vuebackboard.services.RepliesService;
import com.example.vuebackboard.web.dtos.RepliesDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class RepliesController {
    private final RepliesService repliesService;

    @GetMapping("/replies/list")
    public List<RepliesDto> repliesList() { return repliesService.getRepliesList(); }

    @GetMapping("/replies/{id}")
    public RepliesDto getReplies(@PathVariable Long id) {
        return repliesService.getReplies(id);
    }

    @PostMapping("/replies")
    public RepliesEntity create(@RequestBody RepliesDto repliesDto) {
        return repliesService.create(repliesDto);
    }

    @DeleteMapping("/replies/{id}")
    public void delete(@PathVariable Long id) {
        repliesService.delete(id);
    }
}