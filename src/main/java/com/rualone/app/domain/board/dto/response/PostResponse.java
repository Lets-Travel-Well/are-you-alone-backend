package com.rualone.app.domain.board.dto.response;

import com.rualone.app.domain.board.Comment;
import com.rualone.app.domain.board.Post;
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
}
