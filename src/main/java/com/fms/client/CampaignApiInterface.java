package com.fms.client;

import com.fms.model.Campaign;

import java.util.Optional;

public interface CampaignApiInterface {

    Optional<Campaign> getActiveCampaign();

}
