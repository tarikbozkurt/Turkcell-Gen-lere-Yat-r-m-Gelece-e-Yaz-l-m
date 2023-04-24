package com.example.rentacar.core.configuration.exceptions;

import com.example.rentacar.common.constants.ExceptionTypes;
import com.example.rentacar.common.constants.Messages;
import com.example.rentacar.core.exceptions.BusinessException;
import com.example.rentacar.core.utils.results.ExceptionResult;
import jakarta.validation.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //sınıfa diyoruz ki , controllerda çıkabilecek hataları dinleyip yöneteceğimizi belli ediyoruz.
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST) //400
    public ExceptionResult<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception)
    {

        //Bu kısmı yazmamızım sebebi
        /*
        *
        * Map < key , value > <field,defaoultMessage>
            String String tipinde boş hashmap oluşturduk.
            * FieldError tiiğini exception dan gelecek bütün field erorlarına
            * fieldError a atıp döneceğiz.
            *validationErrors.put ile field ve mesahı atıp bunu da döndüreceğiz.
            * KEY           VALUE
            * "cardCvv" : "Length must be between 3 ... "
        *
        * */

        //Map kullanmamızın sebebi hatayı daha okunaklı bir formatta görmek
        Map<String,String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());

        }
        return new ExceptionResult<>(ExceptionTypes.Exception.VALIDATION,validationErrors);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) //422
    public ExceptionResult<Object> handleValidationException(ValidationException exception)
    {
        return new ExceptionResult<>(ExceptionTypes.Exception.VALIDATION,exception);

    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) //422
    public ExceptionResult<Object> handleBusinessException(BusinessException exception) {
        return new ExceptionResult<>(ExceptionTypes.Exception.BUSINESS, exception.getMessage());
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT) //409
    public ExceptionResult<Object> handleDataIntegrityViolationException(DataIntegrityViolationException exception){
        return new ExceptionResult<>(ExceptionTypes.Exception.DATA_INTEGRITY_VIOLATION,exception.getMessage());
    }



    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
    public ExceptionResult<Object> handleRuntimeException(RuntimeException exception) {
        return new ExceptionResult<>(ExceptionTypes.Exception.RUNTIME, exception.getMessage());
    }
}
