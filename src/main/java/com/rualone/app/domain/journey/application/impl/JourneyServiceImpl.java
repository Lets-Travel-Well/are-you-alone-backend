package com.rualone.app.domain.journey.application.impl;

import com.rualone.app.domain.journey.application.JourneyService;
import com.rualone.app.domain.journey.dao.JourneyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class JourneyServiceImpl implements JourneyService {
    private final JourneyRepository journeyRepository;
}
