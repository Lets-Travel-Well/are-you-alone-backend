package com.rualone.app.domain.journey.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class JourneyResponse {
    private Long id;
    private String leaderName;
    private String subject;
    private String content;
    private LocalDate deadLine;
    private LocalDate startDay;
    private Long travelerAllCnt;
    private Long travelerCnt;
    private String image;
    public JourneyResponse(Long id, String leaderName, String subject, String content, LocalDate deadLine, LocalDate startDay, Long travelerCnt){
        this.id = id;
        this.leaderName = leaderName;
        this.subject = subject;
        this.content = content;
        this.deadLine = deadLine;
        this.startDay = startDay;
        this.travelerAllCnt = travelerCnt;
    }
}
