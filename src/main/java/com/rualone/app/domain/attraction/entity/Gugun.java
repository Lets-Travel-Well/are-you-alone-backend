package com.rualone.app.domain.attraction.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Gugun {
	@Id
	private Integer gugunCode;

	private String gugunName;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "sido_code")
	private Sido sido;
}
