package com.example.rentacar.business.dto.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    //entiy yerine dto ya ekliyoruz validationu

    @NotBlank(message = "Kart numarası alanı boş bırakılamız")
    @Length(min =16, max = 16, message = "Kart numarası 16 haneden oluşmalıdır.")
    private String cardNumber;

    @NotBlank(message = "Kart Sahibi bilgisi boş bırakılamaz")
    @Length(min = 5, message = "Kart sahibi bilgisi en az 5 karakterden oluşmalıdır")
    private String cardHolder;

    @Min(value= 2023, message = "Kart sonlanma yılı geçersiz")
    private int cardExpirationYear;


    @Max(value =12)
    @Min(value = 1)
    private int cardExpirationMonth;

    @NotBlank()
    @Length(min =3, max =3)
    private String cardCvv;

}
