package com.turkcellGyGy.commonpackage.configuration.mappers;

import com.turkcellGyGy.commonpackage.utils.mappers.ModelMapperService;
import com.turkcellGyGy.commonpackage.utils.mappers.ModelMapperServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
/* ModelMapperı kullanmamız için yukarıda önce bean olarak tanıtıp çağırdık,
* daha sonra aşağıda bir model mapper nesnesi gönderebiliyoruz.
*
* */

    @Bean
    public ModelMapperService getModelMapperService(ModelMapper mapper){
        return new ModelMapperServiceImpl(mapper);

    }
}
