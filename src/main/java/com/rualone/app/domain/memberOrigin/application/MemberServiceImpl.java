package com.rualone.app.domain.memberOrigin.application;

import com.rualone.app.domain.memberOrigin.dao.MemberRepository;
import com.rualone.app.domain.memberOrigin.dto.request.MemberCreateRequest;
import com.rualone.app.domain.memberOrigin.dto.request.MemberLoginRequest;
import com.rualone.app.domain.memberOrigin.dto.request.MemberModifyRequest;
import com.rualone.app.domain.memberOrigin.entity.Member;
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
    public Boolean checkLoginId(String loginId) {
        return memberRepository.existsByLoginId(loginId).isPresent();
    }

    @Override
    public void join(MemberCreateRequest memberCreateRequest) {
        Member joinMember = memberCreateRequest.toEntity();
        memberRepository.save(joinMember);
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new NotFoundException(Member.class, id));
    }

    @Override
    public Member findByLoginId(String loginId) {
        Member loginMember = memberRepository.findByLoginId(loginId).get();
        return loginMember;
    }

    @Override
    public void modify(MemberModifyRequest memberModifyRequest) {
        Member findMember = findByLoginId(memberModifyRequest.getLoginId());
        findMember.modify(memberModifyRequest);
    }

    @Override
    public void delete(String loginId) {
        Member findMember = findByLoginId(loginId);
        memberRepository.delete(findMember);
    }

    @Override
    public Member login(MemberLoginRequest memberLoginRequest) {
        return memberRepository.findByLoginIdAndPassword(memberLoginRequest.getLoginId(), memberLoginRequest.getPassword()).get();
    }
}
