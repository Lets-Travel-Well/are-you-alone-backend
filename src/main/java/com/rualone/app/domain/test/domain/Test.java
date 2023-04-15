package com.rualone.app.domain.test.domain;

import com.rualone.app.global.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@SuperBuilder
@NoArgsConstructor
@Getter
public class Test extends BaseEntity {
    private String name;
    private int age;
}
