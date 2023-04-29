package com.rualone.app.domain.post.dto.response;

import com.rualone.app.domain.post.Comment;
import com.rualone.app.domain.post.Post;
import lombok.Data;

@Data
public class CommentResponse {
    private Long id;
    private Post post;
    //Todo : member 완성되면 추가
//    private Member member
    private String content;

    public CommentResponse(Comment comment){
        this.id = comment.getId();
        this.post = comment.getPost();
        //Todo : 멤버 완성되면 추가ㅓ
//        this.member  = comment.getMember();
        this.content = comment.getContent();
    }
}
