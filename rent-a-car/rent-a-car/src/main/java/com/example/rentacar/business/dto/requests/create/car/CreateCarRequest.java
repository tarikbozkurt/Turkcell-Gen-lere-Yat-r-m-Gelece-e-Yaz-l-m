package com.example.rentacar.business.dto.requests.create.car;

import com.example.rentacar.common.constants.Messages;
import com.example.rentacar.common.constants.Regex;
import com.example.rentacar.common.utils.annotations.NotFutureYear;
import com.example.rentacar.entity.enumerations.State;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.propertyeditors.TimeZoneEditor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;




@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCarRequest {
    @Min(0)
    private int modelId;

    @Min(1996)
    @NotFutureYear //custom anotation
    private int modelYear;

    @Pattern(regexp = Regex.Plate,message = Messages.Car.PLATE_NOT_VALID)
    private String plate;

    @Min(1)
    @Max(10000)
    private double dailyPrice;



}
