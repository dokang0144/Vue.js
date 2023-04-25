package com.example.vuebackboard.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto implements Serializable {
    private Long idx;
    private String userName;
    private String comment;
    private Long board;
}