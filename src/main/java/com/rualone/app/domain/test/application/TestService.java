package com.rualone.app.domain.test.application;

import com.rualone.app.domain.test.dao.TestRepository;
import com.rualone.app.domain.test.domain.Test;
import com.rualone.app.domain.test.dto.request.TestCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public Test createTest(TestCreateRequest testCreateRequest){
        return testRepository.save(testCreateRequest.toEntity());
    }
}
