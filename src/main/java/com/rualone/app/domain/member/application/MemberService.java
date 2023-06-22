package com.rualone.app.domain.member.application;

import com.rualone.app.domain.member.dto.request.MemberModifyRequest;
import com.rualone.app.domain.member.entity.Member;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MemberService {
    Member findById(Long id);
    Member findByEmail(String email);
    void modify(MemberModifyRequest memberModifyRequest);


    void updateProfileImg(MultipartFile multipartFile, Long memberId);

    void removeProfileImg(Long memberId);

    void delete(String loginId);

}
