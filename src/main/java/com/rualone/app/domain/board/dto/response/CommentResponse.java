package com.rualone.app.domain.board.dto.response;

import com.rualone.app.domain.board.entity.Comment;
import com.rualone.app.domain.board.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentResponse {
    private Long id;
    private String content;
    private String authorName;
    private LocalDateTime createDate;
}
