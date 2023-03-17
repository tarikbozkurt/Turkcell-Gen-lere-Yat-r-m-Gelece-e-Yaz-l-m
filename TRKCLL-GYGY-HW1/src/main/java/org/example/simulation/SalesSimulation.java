package org.example.simulation;

import org.example.entity.Game;
import org.example.entity.Player;
import org.example.entity.Sale;
import org.example.entity.SaleGame;
import org.example.repository.SaleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesSimulation {

    public static void main(String[] args)
    {
        List<Sale> database = new ArrayList<>();

        Player player1 = new Player(1, "9876543210","Tarik","Bozkurt",new Date(),"trkbzkrt",15);

        Game game1 = new Game(1,"CsGo:Global Offensive",15.25);

        SaleGame saleGame = new SaleGame(1,player1,game1.getPrice(),game1);
        database.add(saleGame);


        SaleRepository saleRepository = new SaleRepository(database);


        //Get
        System.out.println("Get: " + saleRepository.getById(1));


        //Update
        saleGame.setAmount(18);
        saleRepository.update(saleGame);
        System.out.println("Update: " + saleRepository.getById(1));


        //Delete
        saleRepository.delete(saleGame);
        System.out.println("Delete : " + saleRepository.getById(1));




    }
}
