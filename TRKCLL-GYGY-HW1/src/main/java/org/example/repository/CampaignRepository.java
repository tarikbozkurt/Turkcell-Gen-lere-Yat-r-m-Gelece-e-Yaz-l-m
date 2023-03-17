package org.example.repository;

import org.example.entity.Campaign;
import org.example.repository.GenericRepositories.GenericListRepository;

import java.util.List;

public class CampaignRepository extends GenericListRepository<Campaign,Integer> {



    public CampaignRepository(List<Campaign> database) {
        super(database);
    }




}
