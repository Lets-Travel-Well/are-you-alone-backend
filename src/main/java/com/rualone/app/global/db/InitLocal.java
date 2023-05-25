package com.rualone.app.global.db;

import com.rualone.app.domain.board.application.CommentService;
import com.rualone.app.domain.board.application.PostLikeService;
import com.rualone.app.domain.board.application.PostService;
import com.rualone.app.domain.board.dto.request.CommentCreateRequest;
import com.rualone.app.domain.board.dto.request.PostCreateRequest;
import com.rualone.app.domain.hotplace.application.HotPlaceService;
import com.rualone.app.domain.journey.application.JourneyService;
import com.rualone.app.domain.journey.dto.request.JourneyCreateRequest;
import com.rualone.app.domain.journey.dto.request.JourneyPlaceCreateRequest;
import com.rualone.app.domain.member.dao.MemberRepository;
import com.rualone.app.domain.member.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile({"local"})
@Slf4j
public class InitLocal {
    // true 일때 DB 넣음
    private boolean initData = false;

    @Bean
    CommandLineRunner init(
            MemberRepository memberRepository,
            PostService postService,
            CommentService commentService,
            PostLikeService postLikeService,
            HotPlaceService hotPlaceService,
            JourneyService journeyService
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

            // attraction like
            Integer[] attractionLike = {125406, 125452, 125484, 125510, 125555, 125661, 125662, 125709, 125761, 125821, 125850, 125945, 126220, 126300, 126301, 126450, 126511, 126514};
            for(Integer contentId : attractionLike){
                for(int i = 1; i <= 50; i++){
                    int check = (int) (Math.random() * 2);
                    if(check == 1){
                        hotPlaceService.changeHotPlace((long)i, contentId);
                    }
                }
            }

            // Journey create - 단건 저장
            // 1
            List<JourneyPlaceCreateRequest> journeyPlaceCreateRequests1 = new ArrayList<>();
            for(int i = 0; i < 5; i++){
                JourneyPlaceCreateRequest journeyPlaceCreateRequest = JourneyPlaceCreateRequest.builder()
                        .contentId(attractionLike[i])
                        .content("content" + i)
                        .build();
                journeyPlaceCreateRequests1.add(journeyPlaceCreateRequest);
            }
            JourneyCreateRequest journeyCreateRequest1 = JourneyCreateRequest.builder()
                    .subject("JourneySubject1")
                    .content("JourneyContent1")
                    .visibility(true)
                    .travelerCnt(4L)
                    .deadLine(LocalDate.parse("2023-06-01"))
                    .startDay(LocalDate.parse("2023-07-01"))
                    .journeyPlaceCreateRequests(journeyPlaceCreateRequests1)
                    .build();
            journeyService.save(journeyCreateRequest1, 1L);

            // 2
            List<JourneyPlaceCreateRequest> journeyPlaceCreateRequests2 = new ArrayList<>();
            for(int i = 5; i < 9; i++){
                JourneyPlaceCreateRequest journeyPlaceCreateRequest = JourneyPlaceCreateRequest.builder()
                        .contentId(attractionLike[i])
                        .content("content" + i)
                        .build();
                journeyPlaceCreateRequests2.add(journeyPlaceCreateRequest);
            }
            JourneyCreateRequest journeyCreateRequest2 = JourneyCreateRequest.builder()
                    .subject("JourneySubject2")
                    .content("JourneyContent2")
                    .visibility(true)
                    .travelerCnt(3L)
                    .deadLine(LocalDate.parse("2023-08-01"))
                    .startDay(LocalDate.parse("2023-09-01"))
                    .journeyPlaceCreateRequests(journeyPlaceCreateRequests2)
                    .build();
            journeyService.save(journeyCreateRequest2, 1L);
        };
    }

}
