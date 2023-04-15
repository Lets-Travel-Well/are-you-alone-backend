package com.rualone.app.domain.test.api;

import com.rualone.app.domain.test.application.TestService;
import com.rualone.app.domain.test.dto.request.TestCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
@Slf4j
public class TestApi {
    private final TestService testService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody TestCreateRequest testCreateRequest){
        testService.createTest(testCreateRequest);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
