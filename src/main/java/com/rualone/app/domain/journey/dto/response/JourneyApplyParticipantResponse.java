package com.rualone.app.domain.journey.dto.response;

import com.rualone.app.domain.journey.entity.ParticipationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class JourneyApplyParticipantResponse {
    private Long id;
    private String nickname;
    private String email;
    private Long footage;
    public JourneyApplyParticipantResponse(Long id, String nickname, String email, Long footage){
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.footage = footage;
    }
}
