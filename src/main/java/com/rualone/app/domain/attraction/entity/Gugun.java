package com.rualone.app.domain.attraction.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Gugun {
	@Id
	private int gugunCode;
	private String gugunName;
	private int sidoCode;
}
