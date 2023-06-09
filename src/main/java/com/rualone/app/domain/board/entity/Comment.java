package com.rualone.app.domain.board.entity;

import com.rualone.app.domain.board.dto.request.CommentUpdateRequest;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
public class Comment extends BaseEntity {
    private String content;

    @ManyToOne()
    @JoinColumn(name = "post_id")
    private Post post;

    // TODO : member
    @ManyToOne()
    @JoinColumn(name = "member_id")
    private Member member;

    public void update(CommentUpdateRequest commentUpdateRequest){
        this.content = commentUpdateRequest.getContent();
    }
}
