package com.turkcellGyGy.filterservice.business.abstracts;

import com.turkcellGyGy.filterservice.business.dto.response.GetAllFilterResponse;
import com.turkcellGyGy.filterservice.business.dto.response.GetFilterResponse;
import com.turkcellGyGy.filterservice.entities.Filter;

import java.util.List;
import java.util.UUID;

public interface FilterService {

    List<GetAllFilterResponse> getAll();
    GetFilterResponse getById(UUID id);

    //bunlar controllerda olmayacak, dış dünyadan bağımsız..
    void add(Filter filter);
    void delete(UUID id);
    void deleteAllByBrandId(UUID brandId);
    void deleteAllByModelId(UUID modelId);
}
