package com.rualone.app.global.db;

import com.rualone.app.domain.board.application.CommentService;
import com.rualone.app.domain.board.application.PostService;
import com.rualone.app.domain.board.dto.request.CommentCreateRequest;
import com.rualone.app.domain.board.dto.request.PostCreateRequest;
import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.domain.member.application.MemberService;
import com.rualone.app.domain.member.dto.request.MemberCreateRequest;
import com.rualone.app.domain.member.entity.Member;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local"})
public class InitLocal {
    // true 일때 DB 넣음
    private boolean initData = false;

    @Bean
    CommandLineRunner init(
            MemberService memberService, PostService postService, CommentService commentService
    ){
        return args -> {
            if(!initData){
                return;
            }
            memberInit(memberService);
            postInit(postService);
            commentInit(commentService);
        };
    }

    private void memberInit(MemberService memberService) {
        MemberCreateRequest memberCreateRequest1 = new MemberCreateRequest("loginId1", "name1", "pass1", "hashcode1", "email1", "domain1");
        MemberCreateRequest memberCreateRequest2 = new MemberCreateRequest("loginId2", "name2", "pass2", "hashcode2", "email2", "domain2");
        memberService.join(memberCreateRequest1);
        memberService.join(memberCreateRequest2);
    }
    private void postInit(PostService postService) {
        Member member = Member.builder()
                .id(1L)
                .build();
        for(int i = 0; i < 100; i++){
            PostCreateRequest postCreateRequest = new PostCreateRequest("subject" + i, "content" + i);
            postService.save(postCreateRequest, member);
        }
    }
    private void commentInit(CommentService commentService) {
        Member member = Member.builder()
                .id(1L)
                .build();
        for(int i = 0; i < 4; i++){
            CommentCreateRequest commentCreateRequest = new CommentCreateRequest(1L, "test" + i);
            commentService.save(commentCreateRequest, member);
        }
    }
}
