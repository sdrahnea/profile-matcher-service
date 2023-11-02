package com.pms.service;

import com.pms.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;



}
