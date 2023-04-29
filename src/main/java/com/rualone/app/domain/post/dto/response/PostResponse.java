package com.rualone.app.domain.post.dto.response;

import com.rualone.app.domain.post.Comment;
import com.rualone.app.domain.post.Post;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PostResponse {
    private Long id;
    private String subject;
    private String content;
    private int hit;
    private List<CommentResponse> commentList = new ArrayList<>();
    public PostResponse(Post post){
        this.id = post.getId();
        this.subject = post.getSubject();
        this.content = post.getContent();
        this.hit = post.getHit();
    }

    public PostResponse(Post post, List<Comment> comments){
        this.id = post.getId();
        this.subject = post.getSubject();
        this.content = post.getContent();
        this.hit = post.getHit();
        List<CommentResponse> commentList = comments.stream()
                .map(content -> new CommentResponse(content))
                .collect(Collectors.toList());

    }
}
