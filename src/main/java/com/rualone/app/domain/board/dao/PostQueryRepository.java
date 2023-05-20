package com.rualone.app.domain.board.dao;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.board.dto.response.CommentResponse;
import com.rualone.app.domain.board.dto.response.PostDetailResponse;
import com.rualone.app.domain.board.dto.response.PostResponse;
import com.rualone.app.domain.board.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.rualone.app.domain.board.entity.QComment.comment;
import static com.rualone.app.domain.board.entity.QPost.post;
import static com.rualone.app.domain.board.entity.QPostLike.postLike;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PostQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<PostResponse> findAll(Pageable pageable) {
        List<PostResponse> postResponses = jpaQueryFactory
                .select(Projections.constructor(PostResponse.class,
                        post.id,
                        post.subject,
                        post.content,
                        post.hit,
                        post.member.name.as("authorName")))
                .from(post)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(postSort(pageable))
                .fetch();

        return postResponses;
    }

    public PostDetailResponse findById(Long id) {
        List<CommentResponse> commentResponses = jpaQueryFactory
                .select(Projections.constructor(CommentResponse.class,
                        comment.id,
                        comment.content,
                        comment.member.name.as("authorName"),
                        comment.createDate))
                .from(comment)
                .where(comment.post.id.eq(id))
                .fetch();
        log.info(commentResponses.toString());
        PostDetailResponse postDetailResponse = jpaQueryFactory
                .select(Projections.constructor(PostDetailResponse.class,
                        post.id,
                        post.subject,
                        post.content,
                        post.hit,
                        post.member.name.as("authorName"),
                        post.createDate))
                .from(post)
                .where(post.id.eq(id))
                .fetchOne();
        postDetailResponse.setCommentList(commentResponses);
        return postDetailResponse;
    }

    private OrderSpecifier<?> postSort(Pageable page) {
        if (!page.getSort().isEmpty()) {
            for (Sort.Order order : page.getSort()) {
                Order direction = order.getDirection().isAscending() ? Order.ASC : Order.DESC;
                switch (order.getProperty()){
                    case "id":
                        return new OrderSpecifier(direction, post.id);
                }
            }
        }
        return null;
    }
}
