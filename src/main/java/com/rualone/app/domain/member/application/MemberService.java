package com.rualone.app.domain.member.application;

import com.rualone.app.domain.member.dto.request.MemberModifyRequest;
import com.rualone.app.domain.member.entity.Member;

public interface MemberService {
    Member findById(Long id);
    Member findByEmail(String email);
    void modify(MemberModifyRequest memberModifyRequest);
    void delete(String loginId);

}
