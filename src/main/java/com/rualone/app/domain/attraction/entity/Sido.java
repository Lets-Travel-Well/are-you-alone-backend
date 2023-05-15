package com.rualone.app.domain.attraction.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Sido {
	@Id
	private int sidoCode;
	private String sidoName;

}
