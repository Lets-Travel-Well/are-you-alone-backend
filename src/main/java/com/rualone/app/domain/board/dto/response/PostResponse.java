package com.rualone.app.domain.board.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostResponse {
    private Long id;
    private String subject;
    private String content;
    private int hit;
    private String authorName;
    private LocalDateTime createDate;
    private Long like;
}
