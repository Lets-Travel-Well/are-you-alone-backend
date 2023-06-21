package com.rualone.app.domain.member.dto.request;

import com.rualone.app.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileImgModifyRequest {
    private MultipartFile profileImg;

    public Member toEntity(Member member) {
        return Member.builder()
                .build();
    }
}
