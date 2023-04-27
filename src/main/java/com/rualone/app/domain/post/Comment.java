package com.rualone.app.domain.post;

import com.rualone.app.domain.post.dto.CommentUpdateDto;
import com.rualone.app.global.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
public class Comment extends BaseEntity {
    private Post post;
    // TODO : member 추가되면 추가 시켜야함
//    private Member  memberId;
    private String content;

    public void update(CommentUpdateDto commentUpdateDto){
        this.content = commentUpdateDto.getContent();
    }
}
