package org.example.Validation;

import org.example.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CheckIdentityService {

    private Player player;

    private List<String> identyNumbers;

    public CheckIdentityService(Player player) {
        this.player = player;

        identyNumbers = new ArrayList<>();
        identyNumbers.add("9876543210");
        identyNumbers.add("5555555555");
        identyNumbers.add("1234567890");
    }

    public boolean validate(){
        for (String identyNumber : identyNumbers) {
            if(player.getIdentityNumber().equals(identyNumber))
            {
                return true;
            }


        }
        return false;
    }
}
