package com.rualone.app.domain.post.dto;

import com.rualone.app.domain.post.Post;
import lombok.Data;

import java.lang.reflect.Member;

@Data
public class CommentUpdateDto {
    private Long id;
    private Post post;
    //Todo : member 완성되면 추가
//    private Member member;
    private String content;
}
