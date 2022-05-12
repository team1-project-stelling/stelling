package com.team1.stelling.domain.dao;

import com.team1.stelling.mapper.IllustProfileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class IllustProfileDAO {
    private final IllustProfileMapper illustProfileMapper;
}
