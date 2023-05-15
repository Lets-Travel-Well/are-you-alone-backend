package com.rualone.app.domain.board.dto;

import com.rualone.app.domain.board.Post;
import lombok.Data;

@Data
public class CommentUpdateDto {
    private Long id;
    private Post post;
    //Todo : member 완성되면 추가
//    private Member member;
    private String content;
}
