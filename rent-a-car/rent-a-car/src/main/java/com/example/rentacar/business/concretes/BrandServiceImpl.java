package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.BrandService;
import com.example.rentacar.business.dto.requests.create.brand.CreateBrandRequest;
import com.example.rentacar.business.dto.requests.update.brand.UpdateBrandRequest;
import com.example.rentacar.business.dto.requests.update.car.UpdateCarRequest;
import com.example.rentacar.business.dto.responses.create.brand.CreateBrandResponse;
import com.example.rentacar.business.dto.responses.get.brand.GetAllBrandsResponse;
import com.example.rentacar.business.dto.responses.get.brand.GetBrandResponse;
import com.example.rentacar.business.dto.responses.update.brand.UpdateBrandResponse;
import com.example.rentacar.business.dto.responses.update.car.UpdateCarResponse;
import com.example.rentacar.entity.Brand;
import com.example.rentacar.entity.Car;
import com.example.rentacar.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository repository;

    public BrandServiceImpl(BrandRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = repository.findAll();
        List<GetAllBrandsResponse> response = new ArrayList<>();

        for (Brand brand : brands) {
            response.add(new GetAllBrandsResponse(brand.getId(),brand.getName()));
        }
        return response;
    }

    @Override
    public GetBrandResponse getById(long id)  {
        checkIfBrandExists(id);
        Brand brand = repository.findById(id).orElseThrow();

        GetBrandResponse response = new GetBrandResponse();
        response.setId(brand.getId());
        response.setName(brand.getName());

      return response;

    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {


        Brand brand = new Brand();
        brand.setName(request.getName());

        repository.save(brand);

        CreateBrandResponse response = new CreateBrandResponse(brand.getId(), brand.getName());


       return response;



    }

    @Override
    public UpdateBrandResponse update(long id, UpdateBrandRequest request) {
        checkIfBrandExists(id);

        Brand brand = repository.findById(id).orElseThrow();

        brand.setName(request.getName());

        repository.save(brand);

        UpdateBrandResponse response = new UpdateBrandResponse(brand.getName());



        return response;
    }

    @Override
    public void delete(long id) {
        checkIfBrandExists(id);
        repository.deleteById(id);
    }



//BUSINESS RULES

private void checkIfBrandExists(long id){
    if(!repository.existsById(id)) throw new IllegalArgumentException("ID NOT FOUND !");

}

}
