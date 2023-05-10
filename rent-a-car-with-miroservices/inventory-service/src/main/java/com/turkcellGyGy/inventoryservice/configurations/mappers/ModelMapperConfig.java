package com.turkcellGyGy.inventoryservice.configurations.mappers;


import com.turkcellGyGy.commonpackage.utils.mappers.ModelMapperService;
import com.turkcellGyGy.commonpackage.utils.mappers.ModelMapperServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ModelMapperService getModelMapperService(ModelMapper mapper) {
        return new ModelMapperServiceImpl(mapper);
    }
}
