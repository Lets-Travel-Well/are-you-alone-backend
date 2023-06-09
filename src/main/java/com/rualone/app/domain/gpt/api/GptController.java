package com.rualone.app.domain.gpt.api;

import com.rualone.app.domain.gpt.application.GptService;
import com.rualone.app.global.api.ApiResult;
import com.rualone.app.global.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.rualone.app.global.api.ApiResult.OK;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/gpt-management")
public class GptController {
    private final GptService gptService;

    //chat-gpt 와 간단한 채팅 서비스 소스
    @PostMapping("/review")
    public ApiResult<String> test(@RequestBody String question) {
        return OK(StringUtils.customTrim(gptService.getChatResponse(question)));
    }
}