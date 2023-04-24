package com.example.rentacar.core.utils.results;


import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResult<T>{
    //generic yapı
    //bir type alıyor
    // type = Object ( herhangi bir şey )
    private LocalDateTime timestamp;

    private String type;

    private T message;

    //mesaj kısmı için T tipi aldık ( string , map, int vb. )

    public ExceptionResult(String type, T message) {
        this.timestamp  = LocalDateTime.now(); //anlık zamanı constructor dolduruyor.
        this.type = type;
        this.message = message;
    }
}
