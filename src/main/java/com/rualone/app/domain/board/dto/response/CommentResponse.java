package com.rualone.app.domain.board.dto.response;

import com.rualone.app.domain.board.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentResponse {
    private Long id;
    private Long postId;
    private String content;
    private String authorName;
    private LocalDateTime createDate;
    private Boolean myComment;
    public CommentResponse(Comment comment){
        this.id = comment.getId();
        this.postId = comment.getPost().getId();
        this.content = comment.getContent();
        this.authorName = comment.getMember().getNickName();
        this.createDate = comment.getCreateDate();
    }
    public CommentResponse(Long id, Long postId, String content, String authorName, LocalDateTime createDate){
        this.id = id;
        this.postId = postId;
        this.content = content;
        this.authorName = authorName;
        this.createDate = createDate;
        this.myComment = false;
    }
}
