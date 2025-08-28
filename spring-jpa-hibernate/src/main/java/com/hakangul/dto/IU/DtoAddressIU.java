package com.hakangul.dto.IU;

import com.hakangul.dto.DtoCustomer;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAddressIU {

    @NotEmpty(message = "Address alanı boş bırakılamaz")
    private String description;

    private DtoCustomer customer;
}
