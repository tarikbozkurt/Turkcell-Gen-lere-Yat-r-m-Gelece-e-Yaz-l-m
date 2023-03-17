package org.example.simulation;

import org.example.entity.Campaign;
import org.example.entity.Game;
import org.example.repository.CampaignRepository;

import java.util.ArrayList;
import java.util.List;

public class CampaignSimulation {
    public static  void main(String[] args){


        List<Campaign> database = new ArrayList<>();

        List<Game> games1 = new ArrayList<>();
        Game game1 = new Game(1,"Assassins Creed:Brotherhood",149);
        games1.add(game1);
        Game game2 = new Game(2,"Sons Of The Forest",499);
        games1.add(game2);

        List<Game> games2 = new ArrayList<>();

        games2.add(game2);
        Game game3 = new Game(3,"GTA V",79);
        games2.add(game3);

        // we are  adding games that have the campaign
         /*
         *
         *
         * For example:
         *
         * There are two games in games1 list, and we want to add a campaign for games1's games
         * */
        Campaign campaign1 = new Campaign(1,games1,50);
        Campaign campaign2 = new Campaign(2,games2,70);

        database.add(campaign1);
        database.add(campaign2);


        CampaignRepository campaignRepository = new CampaignRepository(database);


        //Get By Id
        System.out.println("Get: "+ campaignRepository.getById(1));



        // Get All
        System.out.println("Get All: "+ campaignRepository.getAll());


        //Update
        campaign1.setPrice(49);

        campaignRepository.update(campaign1);
        System.out.println("Update: "+campaignRepository.getById(1));


        //Delete
        campaignRepository.delete(campaign1);
        System.out.println("Delete: "+campaignRepository.getById(1));














    }
}
