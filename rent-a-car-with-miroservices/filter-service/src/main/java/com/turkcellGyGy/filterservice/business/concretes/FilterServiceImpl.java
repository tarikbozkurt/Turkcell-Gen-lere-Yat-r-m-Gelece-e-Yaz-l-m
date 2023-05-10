package com.turkcellGyGy.filterservice.business.concretes;

import com.turkcellGyGy.commonpackage.utils.mappers.ModelMapperService;
import com.turkcellGyGy.filterservice.business.abstracts.FilterService;
import com.turkcellGyGy.filterservice.business.dto.response.GetAllFilterResponse;
import com.turkcellGyGy.filterservice.business.dto.response.GetFilterResponse;
import com.turkcellGyGy.filterservice.entities.Filter;
import com.turkcellGyGy.filterservice.repository.FilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {

    //@RequiredArgsConstructor => final olmazsa olmaz, dependency injection olmaz. Final kullandığımız zaman bu anotasyonu kullanırız.
    //final yazdıklarımızı constructorda newlesin yazmadıklarımızı newlemesin.

    private final ModelMapperService mapper;
    private final FilterRepository repository;

    @Override
    public List<GetAllFilterResponse> getAll() {
        var filters = repository.findAll();

        var response = filters
                .stream()
                .map(filter->mapper.forResponse().map(filter, GetAllFilterResponse.class)).toList();

        return response;
    }

    @Override
    public GetFilterResponse getById(UUID id) {
        var filter = repository.findById(id).orElseThrow(); //burası normalde hata verir. fakat "var" tipinde olduğu için Optional verir.
        //Optional null gelebilir demek oluyor.
        var response = mapper.forResponse().map(filter, GetFilterResponse.class);

        return response;
    }

    @Override
    public void add(Filter filter) {
        filter.setId(UUID.randomUUID());
        repository.save(filter);

    }

    @Override
    public void delete(UUID id) {
    repository.deleteById(id);
    }

    @Override
    public void deleteAllByBrandId(UUID brandId) {

    }

    @Override
    public void deleteAllByModelId(UUID modelId) {

    }
}
