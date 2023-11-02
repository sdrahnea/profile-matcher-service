package com.pms.controller;

import com.pms.model.Player;
import com.pms.service.ProfileMatcher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class ProfileController {

    private final ProfileMatcher profileMatcher;

    @GetMapping(value = "/get_client_config/{player_id}")
    public ResponseEntity<?> getClientConfig(@PathVariable("player_id") String playerId) {
        log.info("Receive request to get client configuration by player ID: {}", playerId);

        Player player = profileMatcher.matchPlayerWithActiveCampaign(playerId);

        return ResponseEntity.ok(player);
    }

}
