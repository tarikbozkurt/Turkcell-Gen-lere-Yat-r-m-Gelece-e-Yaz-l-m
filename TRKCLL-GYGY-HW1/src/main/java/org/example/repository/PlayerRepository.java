package org.example.repository;

import org.example.entity.Player;
import org.example.repository.GenericRepositories.GenericListRepository;

import java.util.List;

public class PlayerRepository extends GenericListRepository<Player,Integer> {


    public PlayerRepository(List<Player> database) {
        super(database);
    }
}
