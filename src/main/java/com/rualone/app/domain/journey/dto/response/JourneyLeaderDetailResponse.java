package com.rualone.app.domain.journey.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class JourneyLeaderDetailResponse {
    private Long id;
    private String subject;
    private String content;
    private Long travelerAllCnt;
    private LocalDate deadLine;
    private LocalDate startDay;

    private Long travelerCnt;
    private Boolean myJourney;
    private List<JourneyPlaceResponse> journeyPlaceResponseList;
    private JourneyParticipantResponse leader;
    private List<MemberApplyResponse> memberApplyResponseList;
    public JourneyLeaderDetailResponse(Long id, String subject, String content, Long travelerAllCnt, LocalDate deadLine, LocalDate startDay){
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.travelerAllCnt = travelerAllCnt;
        this.deadLine = deadLine;
        this.startDay = startDay;
    }
}
