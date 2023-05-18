package com.rualone.app.domain.member.application;

import com.rualone.app.domain.member.dao.MemberRepository;
import com.rualone.app.domain.member.dto.request.MemberCreateRequest;
import com.rualone.app.domain.member.dto.request.MemberLoginRequest;
import com.rualone.app.domain.member.dto.request.MemberModifyRequest;
import com.rualone.app.domain.member.entity.Member;
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
    public Boolean checkLoginId(String loginId) {
        return memberRepository.existsByLoginId(loginId).isPresent();
    }

    @Override
    public void join(MemberCreateRequest memberCreateRequest) {
        Member joinMember = memberCreateRequest.toEntity();
        memberRepository.save(joinMember);
    }

    @Override
    public Member findById(String loginId) {
        Member loginMember = memberRepository.findByLoginId(loginId).get();
        return loginMember;
    }

    @Override
    public void modify(MemberModifyRequest memberModifyRequest) {
        Member findMember = findById(memberModifyRequest.getLoginId());
        findMember.modify(memberModifyRequest);
    }

    @Override
    public void delete(String loginId) {
        Member findMember = findById(loginId);
        memberRepository.delete(findMember);
    }

    @Override
    public Member login(MemberLoginRequest memberLoginRequest) {
        return memberRepository.findByLoginIdAndPassword(memberLoginRequest.getLoginId(), memberLoginRequest.getPassword()).get();
    }
}