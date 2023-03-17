package org.example.simulation;

import org.example.entity.*;
import org.example.repository.SaleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleWithCampaignsSimulation {


    public static void main(String[] args){
        List<Sale> database = new ArrayList<>();

        Player player1 = new Player(1,"9876543210","Yusuf","Demircan", new Date(),"ysufdruk",17);

        Game game = new Game(1,"Tetris", 15.25);
        SaleGame saleGame1 = new SaleGame(1, player1, game.getPrice(), game);

        database.add(saleGame1);

        List<Game> games1 = new ArrayList<>();
        Game game2 = new Game(2, "Fifa 2023", 70);
        games1.add(game2);
        Game game3 = new Game(3, "Mario Bros 2022", 50);
        games1.add(game3);
        Campaign campaign1 = new Campaign(1, games1, 80);
        SaleCampaign saleCampaign1 = new SaleCampaign(2, player1,
                campaign1.getPrice(), campaign1);
        database.add(saleCampaign1);

        SaleRepository saleRepository = new SaleRepository(database);

        //Get All
        System.out.println("Get all: " + saleRepository.getAll());


        //Update
        saleCampaign1.setAmount(saleCampaign1.getAmount()-10);

        saleRepository.update(saleCampaign1);

        System.out.println("Update: " + saleRepository.getById(saleCampaign1.getId()));

        //Delete
        saleRepository.delete(saleCampaign1);
        System.out.println("Deleted: " + saleRepository.getById(saleCampaign1.getId()));



    }



}
