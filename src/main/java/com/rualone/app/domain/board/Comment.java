package com.rualone.app.domain.board;

import com.rualone.app.domain.board.dto.CommentUpdateDto;
import com.rualone.app.global.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
public class Comment extends BaseEntity {
    private String content;
    @ManyToOne
    private Post post;
    // TODO : member 추가되면 추가 시켜야함
//    private Member  memberId;


    public void update(CommentUpdateDto commentUpdateDto){
        this.content = commentUpdateDto.getContent();
    }
}
