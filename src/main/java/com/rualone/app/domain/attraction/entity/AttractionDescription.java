package com.rualone.app.domain.attraction.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class AttractionDescription {
	@Id
	private int contentId;
	private String homepage;
	private String overview;
	private String telname;

}
