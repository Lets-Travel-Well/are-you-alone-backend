package com.rualone.app.domain.board.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.board.dto.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.rualone.app.domain.board.entity.QComment.comment;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CommentQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<CommentResponse> findAllByPostId(Long postId){
        List<CommentResponse> commentResponses = jpaQueryFactory
                .select(Projections.constructor(CommentResponse.class,
                        comment.id,
                        comment.post.id,
                        comment.content,
                        comment.member.nickName.as("authorName"),
                        comment.createDate))
                .from(comment)
                .where(comment.post.id.eq(postId))
                .fetch();
        return commentResponses;
    }
}
