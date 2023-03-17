package org.example.simulation;

import org.example.Validation.CheckIdentityService;
import org.example.entity.Player;
import org.example.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerSimulation {

    public static  void main(String[] args) {


        List<Player> database = new ArrayList<>();


        Player player1 = new Player(1, "9876543210","Tarik","Bozkurt",new Date(),"trkbzkrt",15);

        database.add(player1);


        PlayerRepository playerRepository = new PlayerRepository(database);

    // Get
        System.out.println("Get: " + playerRepository.getById(1));

        //Validate Identity Number
        CheckIdentityService checkIdentityService = new CheckIdentityService(playerRepository.getById(1));

        System.out.println("Does the service contain the player identity number of id 1?: "+ checkIdentityService.validate());


        //Update
        player1.setFirstName("Yusuf");
        playerRepository.update(player1);

        System.out.println("Get: "+ playerRepository.getById(1));


        //Delete
        playerRepository.delete(playerRepository.getById(1));
        System.out.println("Deleted: " + playerRepository.getById(1));



    }
    }

