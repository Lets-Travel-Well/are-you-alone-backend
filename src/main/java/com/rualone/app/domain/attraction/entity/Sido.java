package com.rualone.app.domain.attraction.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Sido {
	@Id
	private Integer sidoCode;
	@Column()
	private String sidoName;

}
