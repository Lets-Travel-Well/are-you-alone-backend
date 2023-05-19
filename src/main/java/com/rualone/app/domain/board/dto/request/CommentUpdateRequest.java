package com.rualone.app.domain.board.dto.request;

import lombok.Data;

@Data
public class CommentUpdateRequest {
    private Long id;
    private String content;

}
