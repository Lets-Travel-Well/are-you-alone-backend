package com.rualone.app.domain.board.entity;

import com.rualone.app.domain.board.dto.request.PostUpdateRequest;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
public class Post extends BaseEntity {
    private String subject;
    private String content;
    private int hit;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    List<Comment> commentList = new ArrayList<>();
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
