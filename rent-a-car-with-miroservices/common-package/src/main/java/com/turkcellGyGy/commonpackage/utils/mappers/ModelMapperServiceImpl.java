package com.turkcellGyGy.commonpackage.utils.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import org.modelmapper.convention.MatchingStrategies;



@Service
@AllArgsConstructor
public class ModelMapperServiceImpl implements ModelMapperService{

    private final ModelMapper mapper;



   /*
   setAmbiguityIgnored ( true ) ifadesi bize şöyle bir yapı verir..

    diyelim ki Map iki yapıyı kıyaslıyor. Elimizde;

    ad , soyad , t.c

    olduğunu düşünelim. Ama maplemek istediğimiz yerde ise sadece;

     ad , soyad  var.   Bu tip durumlarda hata mı vereyim yoksa devam edip görmezden mi geleyim kısmının çalıştığı ve onaylandığı yer
     burası


    */
    @Override
    public ModelMapper forResponse() {
        mapper.getConfiguration()
                .setAmbiguityIgnored(true) //Maplerdeki belirsizlik durumu için ( brand_id yoksa mesela maplerken,) Hata versin mi vermesin mi mantığı.
                .setMatchingStrategy(MatchingStrategies.LOOSE); //araçta brand name yok mesela, brand name isteniyorsa gibi durumlar için esnek bırakıyoruz loose yaparak.

        return mapper;

    }

    @Override
    public ModelMapper forRequest() {
        mapper.getConfiguration()
                .setAmbiguityIgnored(true) //Maplerdeki belirsizlik durumu için ( brand_id yoksa mesela maplerken,) Hata versin mi vermesin mi mantığı.
                .setMatchingStrategy(MatchingStrategies.STANDARD); // STRICT:REQUEST işlemi yaparkan id alanımız yok, Strıck problem çıkarır bu sebeple standart kullandık.
        return mapper;
    }
}
