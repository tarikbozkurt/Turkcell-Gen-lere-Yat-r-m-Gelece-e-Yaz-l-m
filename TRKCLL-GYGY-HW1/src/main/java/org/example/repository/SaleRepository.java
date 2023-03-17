package org.example.repository;

import org.example.entity.Sale;
import org.example.repository.GenericRepositories.GenericListRepository;

import java.util.List;

public class SaleRepository extends GenericListRepository<Sale,Integer> {
    public SaleRepository(List<Sale> database) {
        super(database);
    }
}
