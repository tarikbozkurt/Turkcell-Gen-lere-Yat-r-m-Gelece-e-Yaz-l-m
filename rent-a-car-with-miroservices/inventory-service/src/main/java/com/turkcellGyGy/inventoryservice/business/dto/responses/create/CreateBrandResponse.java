package com.turkcellGyGy.inventoryservice.business.dto.responses.create;

import com.turkcellGyGy.inventoryservice.entity.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBrandResponse {
    private UUID id;
    private String name;
}

