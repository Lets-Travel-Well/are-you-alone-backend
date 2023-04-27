package com.rualone.app.domain.post.dto.response;

import com.rualone.app.domain.post.Post;
import lombok.Data;

@Data
public class PostResponse {
    private Long id;
    private String subject;
    private String content;
    private int hit;
    public PostResponse(Post post){
        this.id = post.getId();
        this.subject = post.getSubject();
        this.content = post.getContent();
        this.hit = post.getHit();
    }
}
