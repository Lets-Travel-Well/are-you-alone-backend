package com.rualone.app.global.db;

import com.rualone.app.domain.board.application.CommentService;
import com.rualone.app.domain.board.application.PostLikeService;
import com.rualone.app.domain.board.application.PostService;
import com.rualone.app.domain.board.dao.PostRepository;
import com.rualone.app.domain.board.dto.request.CommentCreateRequest;
import com.rualone.app.domain.board.dto.request.PostCreateRequest;
import com.rualone.app.domain.member.dao.MemberRepository;
import com.rualone.app.domain.member.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local"})
@Slf4j
public class InitLocal {
    // true 일때 DB 넣음
    private boolean initData = true;

    @Bean
    CommandLineRunner init(
            MemberRepository memberRepository, PostService postService, CommentService commentService, PostLikeService postLikeService
    ){
        return args -> {
            if(!initData){
                return;
            }
            // member
            for(int i = 0; i < 50; i++){
                Member member = Member.builder()
                        .email("test" + i + " @test.com")
                        .nickName("test" + i + " NickName")
                        .build();
                memberRepository.save(member);
            }

            // post
            for(int i = 0; i < 100; i++){
                PostCreateRequest postCreateRequest = PostCreateRequest.builder()
                        .subject("paginationTest" + i)
                        .content("Test" + i + "내용 입니다.")
                        .build();
                long m = (long) (Math.random()*50 + 1);
                postService.save(postCreateRequest, Member.builder().id(m).build());
            }

            // comment
            for(int i = 0; i < 400; i++){
                long c = (long) (Math.random() * 100 + 1);
                CommentCreateRequest commentCreateRequest = CommentCreateRequest.builder()
                        .postId(c)
                        .content("comment" + i + "입니다")
                        .build();
                long m = (long) (Math.random()*50 + 1);
                commentService.save(commentCreateRequest, Member.builder().id(m).build());
            }

            // post like
            for(int i = 1; i <= 100; i++){
                for(int j = 1; j <= 50; j++){
                    int check = (int) (Math.random() * 2);
                    if(check == 1){
                        postLikeService.changLike((long)j, (long)i);
                    }
                }
            }
        };
    }

}
