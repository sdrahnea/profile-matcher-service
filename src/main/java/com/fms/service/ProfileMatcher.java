package com.fms.service;

import com.fms.client.CampaignClient;
import com.fms.model.Campaign;
import com.fms.model.Level;
import com.fms.model.Matcher;
import com.fms.model.Player;
import com.fms.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ProfileMatcher {

    private final PlayerRepository playerRepository;
    private final CampaignClient campaignClient;

    public Player matchPlayerWithActiveCampaign(final String playerId) {
        Optional<Player> maybePlayer = playerRepository.findById(playerId);
        if(maybePlayer.isEmpty()) {
            throw new RuntimeException("Player with " + playerId + " ID does not exist!");
        } else {
            Player player = maybePlayer.get();
            Optional<Campaign> maybeCampaign = campaignClient.getActiveCampaign();
            if(maybeCampaign.isEmpty()){
                throw new RuntimeException("No active campaign!");
            } else {
                Campaign campaign = maybeCampaign.get();
                Matcher matcher = campaign.getMatchers();

                if(!hasRequiredLevel(player, matcher.getLevel())){
                    throw new RuntimeException("Player does not have required level!");
                }

                if(!hasRequiredCountry(player, matcher.getHas().getCountry())) {
                    throw new RuntimeException("Player does not have required country!");
                }

                List<String> campaignHasItems = matcher.getHas().getItems();
                List<String> campaignDoesNotHasItems = matcher.getDoes_not_have().getItems();

                List<String> playerItemList = new ArrayList<>(player.getInventory().keySet().stream()
                        .filter(key -> key.contains("item_"))
                        .collect(Collectors.toList()));

                if(playerItemList.containsAll(campaignHasItems) && !playerItemList.containsAll(campaignDoesNotHasItems)) {
                    List<String> playerActiveCampaign = player.getActive_campaigns();
                    playerActiveCampaign.add(campaign.getName());
                    player.setActive_campaigns(playerActiveCampaign);

                    playerRepository.save(player, playerId);

                    return player;
                } else {
                    throw new RuntimeException("Player does not have required campaign items!");
                }

            }
        }
    }

    boolean hasRequiredLevel(Player player, Level campaignLevel) {
        return campaignLevel.getMin() <= player.getLevel() && player.getLevel() <= campaignLevel.getMax();
    }

    boolean hasRequiredCountry(Player player, List<String> country) {
        return country.contains(player.getCountry());
    }

    private List<String> getPlayerItems(Map<String, Object> playerItems) {
      return null;
    }

}
