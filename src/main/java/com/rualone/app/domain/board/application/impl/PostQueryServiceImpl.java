package com.rualone.app.domain.board.application.impl;

import com.rualone.app.domain.board.application.PostQueryService;
import com.rualone.app.domain.board.dao.PostQueryRepository;
import com.rualone.app.domain.board.dto.response.PostDetailResponse;
import com.rualone.app.domain.board.dto.response.PostResponse;
import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.domain.board.validator.PostValidator;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.domain.member.validator.MemberValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class PostQueryServiceImpl implements PostQueryService {
    private final PostQueryRepository postQueryRepository;
    private final PostValidator postValidator;
    private final MemberValidator memberValidator;
    @Override
    @Transactional
    public PostDetailResponse findById(Long id, Long memberId) {
        Post post = postValidator.findById(id);
        Member member = memberValidator.findById(memberId);

        PostDetailResponse postDetailResponse = postQueryRepository.findById(id);

        postDetailResponse.setMyBoard(member.getNickName().equals(postDetailResponse.getAuthorName()));

        postDetailResponse.getCommentList().forEach(commentResponse -> {
            if(commentResponse.getAuthorName().equals(member.getNickName())){
                log.info("{}",commentResponse);
                commentResponse.setMyComment(true);
            }
        });
        postDetailResponse.setLike(postQueryRepository.isLike(id, memberId));
        post.increaseHit();
        return postDetailResponse;
    }

    @Override
    public Page<PostResponse> findAll(Pageable pageable) {
        return postQueryRepository.findAll(pageable);
    }
}
