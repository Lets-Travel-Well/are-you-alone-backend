package com.rualone.app.domain.member.application;

import com.rualone.app.domain.member.dao.MemberRepository;
import com.rualone.app.domain.member.dto.request.MemberModifyRequest;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new NotFoundException(Member.class, id));
    }

    @Override
    public Member findByEmail(String email) {
        Member loginMember = memberRepository.findByEmail(email).get();
        return loginMember;
    }

    @Override
    public void modify(MemberModifyRequest memberModifyRequest) {
        Member findMember = findByEmail(memberModifyRequest.getEmail());
        findMember.modify(memberModifyRequest);
    }

    @Override
    public void delete(String loginId) {
        Member findMember = findByEmail(loginId);
        memberRepository.delete(findMember);
    }

}
