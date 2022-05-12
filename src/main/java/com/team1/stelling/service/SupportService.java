package com.team1.stelling.service;

import com.team1.stelling.domain.dao.SupportDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SupportService{
    private final SupportDAO supportDAO;
}
