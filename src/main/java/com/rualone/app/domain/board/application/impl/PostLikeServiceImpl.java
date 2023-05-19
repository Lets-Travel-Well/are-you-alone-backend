package com.rualone.app.domain.board.application.impl;

import com.rualone.app.domain.board.application.PostLikeService;
import com.rualone.app.domain.board.dao.PostLikeRepository;
import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.domain.board.entity.PostLike;
import com.rualone.app.domain.board.validator.PostValidator;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.domain.member.validator.MemberValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PostLikeServiceImpl implements PostLikeService {
    private final PostLikeRepository postLikeRepository;
    private final PostValidator postValidator;
    private final MemberValidator memberValidator;
    @Override
    public Boolean changLike(Long memberId, Long postId) {
        if(isExisted(memberId, postId)){
            PostLike findPostLike = postLikeRepository.findByMember_IdAndPost_Id(memberId, postId).get();
            postLikeRepository.delete(findPostLike);
            return Boolean.FALSE;
        }
        Member findMember = memberValidator.findById(memberId);
        Post findPost = postValidator.findById(postId);
        postLikeRepository.save(new PostLike(findMember, findPost));
        return Boolean.TRUE;
    }

    private Boolean isExisted(Long memberId, Long postId){
        return postLikeRepository.existsPostLikeByMember_IdAndPost_Id(memberId, postId);
    }
}
