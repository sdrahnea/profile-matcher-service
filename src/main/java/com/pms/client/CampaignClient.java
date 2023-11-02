package com.pms.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pms.model.Campaign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Component
@Slf4j
public class CampaignClient implements CampaignApiInterface {

    @Override
    public Optional<Campaign> getActiveCampaign() {

        try {
            File file = new File("src/main/resources/campaigns/campaign_data.json");

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.registerModule(new JavaTimeModule());
            Campaign campaign = objectMapper.readValue(file, Campaign.class);

            return Optional.of(campaign);
        } catch (IOException ioException) {
            log.error("Error during receiving a campaign: ", ioException);
            return Optional.empty();
        }
    }

}
