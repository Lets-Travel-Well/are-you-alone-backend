package com.rualone.app.domain.memberOrigin.validator;

import com.rualone.app.domain.memberOrigin.dao.MemberRepository;
import com.rualone.app.domain.memberOrigin.entity.Member;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MemberValidator {
    private final MemberRepository memberRepository;
    public Member findById(Long id){
        return memberRepository.findById(id).orElseThrow(() -> new NotFoundException(Member.class, id));
    }
}
