package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.dto.requests.create.rental.CreateRentalRequest;
import com.example.rentacar.business.dto.requests.update.rental.UpdateRentalRequest;
import com.example.rentacar.business.dto.responses.create.rental.CreateRentalResponse;
import com.example.rentacar.business.dto.responses.get.rental.GetAllRentalResponse;
import com.example.rentacar.business.dto.responses.get.rental.GetRentalResponse;
import com.example.rentacar.business.dto.responses.update.rental.UpdateRentalResponse;

import java.util.List;

public interface RentalService {

    List<GetAllRentalResponse> getAll();
    GetRentalResponse getById(long id);
    CreateRentalResponse add(CreateRentalRequest request);
    UpdateRentalResponse update(long id, UpdateRentalRequest request);
    void deleteById(long id);

}
