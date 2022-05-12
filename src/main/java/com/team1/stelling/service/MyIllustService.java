package com.team1.stelling.service;

import com.team1.stelling.mapper.MyIllustMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyIllustService{
    private final MyIllustMapper myIllustMapper;
}
