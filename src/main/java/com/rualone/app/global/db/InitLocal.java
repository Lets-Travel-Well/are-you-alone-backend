package com.rualone.app.global.db;

import com.rualone.app.domain.member.application.MemberService;
import com.rualone.app.domain.member.dto.request.MemberCreateRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local"})
public class InitLocal {
    // true 일때 DB 넣음
    private boolean initData = true;

    @Bean
    CommandLineRunner init(
            MemberService memberService
    ){
        return args -> {
            if(!initData){
                return;
            }
           memberInit(memberService);
        };
    }

    private void memberInit(MemberService memberService) {
        MemberCreateRequest memberCreateRequest1 = new MemberCreateRequest("loginId1", "name1", "pass1", "hashcode1", "email1", "domain1");
        MemberCreateRequest memberCreateRequest2 = new MemberCreateRequest("loginId2", "name2", "pass2", "hashcode2", "email2", "domain2");
        memberService.join(memberCreateRequest1);
        memberService.join(memberCreateRequest2);
    }

}
