package com.rualone.app.domain.board.dto.request;

import com.rualone.app.domain.board.entity.Comment;
import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentCreateRequest {
    private Long postId;
    private String content;
    //TODO : member 완성되면 추가
    //    private Member  memberId;

    public Comment toEntity(Post post, Member loginMember){
        return Comment.builder()
                .post(post)
                .content(content)
                .member(loginMember)
                .build();
    }
}
