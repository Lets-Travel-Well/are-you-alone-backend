package com.rualone.app.domain.board.entity;

import com.rualone.app.domain.board.dto.request.PostUpdateRequest;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
public class Post extends BaseEntity {
    private String subject;
    private String content;
    private int hit;

    // TODO : member
    @ManyToOne()
    @JoinColumn(name = "member_id")
    private Member member;
    public void update(PostUpdateRequest postUpdateRequest){
        this.subject = postUpdateRequest.getSubject();
        this.content = postUpdateRequest.getContent();
    }

    public void increaseHit(){
        this.hit++;
    }
}
