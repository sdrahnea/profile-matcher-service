package com.pms.client;

import com.pms.model.Campaign;

import java.util.Optional;

public interface CampaignApiInterface {

    Optional<Campaign> getActiveCampaign();

}
