package com.rualone.app.domain.board.dto.response;

import com.rualone.app.domain.board.entity.Comment;
import com.rualone.app.domain.board.entity.Post;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PostDetailResponse {
    private Long id;
    private String subject;
    private String content;
    private int hit;
    private List<CommentResponse> commentList = new ArrayList<>();

    public PostDetailResponse(Post post){
        this.id = post.getId();
        this.subject = post.getSubject();
        this.content = post.getContent();
        this.hit = post.getHit();
    }

    public PostDetailResponse(Post post, List<Comment> comments){
        this.id = post.getId();
        this.subject = post.getSubject();
        this.content = post.getContent();
        this.hit = post.getHit();
        this.commentList = comments.stream()
                .map(content -> new CommentResponse(content))
                .collect(Collectors.toList());

    }
}
