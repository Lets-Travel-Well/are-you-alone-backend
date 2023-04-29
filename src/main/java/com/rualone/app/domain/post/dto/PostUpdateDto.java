package com.rualone.app.domain.post.dto;

import lombok.Data;

@Data
public class PostUpdateDto {
    private Long id;
    private String subject;
    private String content;

}
