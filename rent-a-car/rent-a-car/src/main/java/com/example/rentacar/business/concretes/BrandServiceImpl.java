package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.BrandService;
import com.example.rentacar.business.dto.requests.create.brand.CreateBrandRequest;
import com.example.rentacar.business.dto.requests.update.brand.UpdateBrandRequest;
import com.example.rentacar.business.dto.responses.create.brand.CreateBrandResponse;
import com.example.rentacar.business.dto.responses.get.brand.GetAllBrandsResponse;
import com.example.rentacar.business.dto.responses.get.brand.GetBrandResponse;
import com.example.rentacar.business.dto.responses.update.brand.UpdateBrandResponse;
import com.example.rentacar.entity.Brand;
import com.example.rentacar.repository.BrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository repository;
    private final ModelMapper modelMapper;
    public BrandServiceImpl(BrandRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = repository.findAll();
        List<GetAllBrandsResponse> response = brands
                .stream()
                .map( brand -> modelMapper.map(brand, GetAllBrandsResponse.class)).toList();


    return response;
    }

    @Override
    public GetBrandResponse getById(long id)  {
        checkIfBrandExists(id);
        Brand brand = repository.findById(id).orElseThrow();

        GetBrandResponse response = modelMapper.map(brand,GetBrandResponse.class);

      return response;

    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {

        Brand data = modelMapper.map(request,Brand.class);

        repository.save(data);

        CreateBrandResponse dataDto = modelMapper.map(data, CreateBrandResponse.class);

       return dataDto;



    }

    @Override
    public UpdateBrandResponse update(long id, UpdateBrandRequest request) {
        checkIfBrandExists(id);
        //** We can use request id for saving like save data method.. ?


        return null;
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
