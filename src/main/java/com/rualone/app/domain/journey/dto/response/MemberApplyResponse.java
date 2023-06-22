package com.rualone.app.domain.journey.dto.response;

import com.rualone.app.domain.journey.entity.ParticipationStatus;
import lombok.Data;

@Data
public class MemberApplyResponse {
    private Long id;
    private String nickName;
    private String email;
    private Long footage;
    private ParticipationStatus status;
    public MemberApplyResponse(Long id, String nickName, String email, Long footage, ParticipationStatus status){
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.footage = footage;
        this.status = status;
    }
}
