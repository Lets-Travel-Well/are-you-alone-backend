package com.rualone.app.domain.test.dto.request;

import com.rualone.app.domain.test.domain.Test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TestCreateRequest {
    private String name;
    private int age;

    public Test toEntity(){
        return Test.builder()
                .name(name)
                .age(age)
                .build();
    }
}
