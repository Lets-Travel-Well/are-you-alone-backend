package com.rualone.app.domain.board.entity;

import com.rualone.app.domain.board.dto.request.PostUpdateRequest;
import com.rualone.app.global.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
public class Post extends BaseEntity {
    private String subject;
    private String content;
    private int hit;
    // TODO : member 추가되면 추가 시켜야함
//    private Member member;
    public void update(PostUpdateRequest postUpdateRequest){
        this.subject = postUpdateRequest.getSubject();
        this.content = postUpdateRequest.getContent();
    }
}
