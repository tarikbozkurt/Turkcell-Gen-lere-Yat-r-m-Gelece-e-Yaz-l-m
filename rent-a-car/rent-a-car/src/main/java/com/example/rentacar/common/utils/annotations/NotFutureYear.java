package com.example.rentacar.common.utils.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD,ElementType.PARAMETER}) //HEDEF aldığı tipler, nerelerde kullanacağız bu anotasyonu..
@Retention(RetentionPolicy.RUNTIME)//
@Constraint(validatedBy = NotFutureYearValidator.class) // class ı buraya bağlamış olduk.
//  @interface  şeklinde tanımlanır ve 3 özellik alır..
public @interface NotFutureYear {


    //mesaj kısmı verilmediyse dönecek olan mesajı buraya yazıyoruz.
    String message() default "Model year value cannot be in the future";


    //Her tipten bir class olabilir array class olabilir
    //farklı kullanıcılara özgü doğrulama setleri tanımlayabiliriz.
    //örneğin admin rolü vb..
    //mesela admin kullanıcısına özel yapabiliriz.
    //farklı kullanıcı grublarına özelleştirilmiş veya özellikler tanımlamak için kullanılır.
    Class<?>[] groups() default{};


    //belirli bir grubun mesajını taşır
    //Örneğin adminler grubu için adminlker ile alakalı mesajları döner
    // veri transfer nesnelerinde belirli bir grubun mesajlarını taşımak için kullanılır.
    Class<? extends Payload>[] payload() default {};

}
