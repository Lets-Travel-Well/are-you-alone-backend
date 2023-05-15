package com.rualone.app.domain.board.dto.request;

import com.rualone.app.domain.board.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCreateRequest {
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
