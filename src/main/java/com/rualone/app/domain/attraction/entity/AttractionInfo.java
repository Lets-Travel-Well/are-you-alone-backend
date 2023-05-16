package com.rualone.app.domain.attraction.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class AttractionInfo {
    @Id
    private Integer contentId;
    private Integer contentTypeId;
    private String title;
    private String addr1;
    private String addr2;
    private String zipcode;
    private String tel;
    private String firstImage;
    private String firstImage2;
    @Column(name = "readcount")
    private Integer readCount;
    private Double latitude;
    private Double longitude;
    private String mlevel;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "sido_code")
    private Sido sido;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "gugun_code")
    private Gugun gugun;
}