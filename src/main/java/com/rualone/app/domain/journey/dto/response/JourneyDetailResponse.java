package com.rualone.app.domain.journey.dto.response;

import com.rualone.app.domain.journey.entity.ParticipationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class JourneyDetailResponse {
    private Long id;
    private String subject;
    private String content;
    private Long travelerAllCnt;
    private LocalDate deadLine;
    private LocalDate startDay;
    private Boolean complete;
    private Long travelerCnt;
    private Boolean myJourney;
    private List<JourneyPlaceResponse> journeyPlaceResponseList;
    private JourneyParticipantResponse leader;
    private List<JourneyParticipantResponse> fuddy;
    private ParticipationStatus status;
    public JourneyDetailResponse(Long id, String subject, String content, Long travelerAllCnt, LocalDate deadLine, LocalDate startDay, Boolean complete){
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.travelerAllCnt = travelerAllCnt;
        this.deadLine = deadLine;
        this.startDay = startDay;
        this.complete = complete;
    }
}
