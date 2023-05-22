package com.rualone.app.domain.memberOrigin.application;

import com.rualone.app.domain.memberOrigin.dto.request.MemberCreateRequest;
import com.rualone.app.domain.memberOrigin.dto.request.MemberLoginRequest;
import com.rualone.app.domain.memberOrigin.dto.request.MemberModifyRequest;
import com.rualone.app.domain.memberOrigin.entity.Member;

public interface MemberService {
    Boolean checkLoginId(String loginId);
    void join(MemberCreateRequest memberCreateRequest);
    Member findById(Long id);
    Member findByLoginId(String loginId);
    void modify(MemberModifyRequest memberModifyRequest);
    void delete(String loginId);

    Member login(MemberLoginRequest memberLoginRequest);
}
