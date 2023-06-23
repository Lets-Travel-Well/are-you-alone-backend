package com.rualone.app.domain.journey.dto.response;

import com.rualone.app.domain.journey.entity.ParticipationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class JourneyApplyParticipantResponse {
    private Long id;
    private String nickName;
    private String email;
    private Long footage;
    public JourneyApplyParticipantResponse(Long id, String nickName, String email, Long footage){
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.footage = footage;
    }
}
