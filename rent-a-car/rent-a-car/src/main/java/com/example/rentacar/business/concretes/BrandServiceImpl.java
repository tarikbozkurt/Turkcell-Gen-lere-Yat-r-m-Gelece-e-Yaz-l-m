package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.BrandService;
import com.example.rentacar.entites.Brand;
import com.example.rentacar.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository repository;

    public BrandServiceImpl(BrandRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Brand> getAll() {

        return repository.findAll();
    }

    @Override
    public Brand getById(int id)  {
        checkIfBrandExists(id);
      return repository.findById(id).orElseThrow();

    }

    @Override
    public Brand add(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public Brand update(int id, Brand brand) {
        checkIfBrandExists(id);
        brand.setId(id);
        return repository.save(brand);
    }

    @Override
    public void delete(int id) {
        checkIfBrandExists(id);
        repository.deleteById(id);
    }



//BUSINESS RULES

private void checkIfBrandExists(int id){
    if(!repository.existsById(id)) throw new IllegalArgumentException("ID NOT FOUND !");

}

}
