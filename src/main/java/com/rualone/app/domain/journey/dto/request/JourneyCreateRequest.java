package com.rualone.app.domain.journey.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rualone.app.domain.journey.entity.Journey;
import com.rualone.app.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class JourneyCreateRequest {
    private String subject;
    private String content;
    private Boolean visibility;
    private int travelerCnt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadLine;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDay;
    List<JourneyPlaceCreateRequest> journeyPlaceCreateRequests;

    public Journey toEntity(Member member){
        return Journey.builder()
                .leader(member)
                .subject(subject)
                .content(content)
                .visibility(visibility)
                .travelerCnt(travelerCnt)
                .complete(false)
                .deadLine(deadLine)
                .startDay(startDay)
                .build();
    }
}
