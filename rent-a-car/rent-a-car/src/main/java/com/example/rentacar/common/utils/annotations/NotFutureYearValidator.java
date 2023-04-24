package com.example.rentacar.common.utils.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

// <A,T> A: anotation , T : Usage field type ( exp. publice int ... **int)
public class NotFutureYearValidator implements ConstraintValidator<NotFutureYear,Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
       int currentYear = Year.now().getValue();
        return value <= currentYear;
    }
}
