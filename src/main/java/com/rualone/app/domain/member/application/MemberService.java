package com.rualone.app.domain.member.application;

import com.rualone.app.domain.member.dto.request.MemberCreateRequest;
import com.rualone.app.domain.member.dto.request.MemberLoginRequest;
import com.rualone.app.domain.member.dto.request.MemberModifyRequest;
import com.rualone.app.domain.member.entity.Member;

public interface MemberService {
    Boolean checkLoginId(String loginId);
    void join(MemberCreateRequest memberCreateRequest);
    Member findByLoginId(String loginId);
    void modify(MemberModifyRequest memberModifyRequest);
    void delete(String loginId);

    Member login(MemberLoginRequest memberLoginRequest);
}
