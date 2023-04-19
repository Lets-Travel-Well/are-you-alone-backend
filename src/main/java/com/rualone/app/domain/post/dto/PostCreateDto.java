package com.rualone.app.domain.post.dto;

import com.rualone.app.domain.post.Post;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class PostCreateDto {
    private String subject;
    private String content;
    // TODO : member 추가되면 추가 시켜야함
    public Post toEntity(){
        return Post.builder()
                .subject(subject)
                .content(content)
                .hit(0)
//                .member()
                .build();
    }
}
