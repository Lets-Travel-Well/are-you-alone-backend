package com.rualone.app.domain.board.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostUpdateRequest {
    private Long id;
    private String subject;
    private String content;
}
