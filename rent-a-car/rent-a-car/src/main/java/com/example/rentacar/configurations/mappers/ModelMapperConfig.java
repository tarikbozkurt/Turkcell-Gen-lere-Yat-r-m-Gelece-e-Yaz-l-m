package com.example.rentacar.configurations.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    //spring boot çalıştığında buraya gelip
    //bir model mapper oluşturacak
    //birdaha new lemeyecek..
    @Bean
public ModelMapper getModelMapper(){
    return new ModelMapper();
}


}
