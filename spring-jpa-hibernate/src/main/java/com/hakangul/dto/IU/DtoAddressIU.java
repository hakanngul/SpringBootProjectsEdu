package com.hakangul.dto.IU;
import com.hakangul.dto.DtoCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAddressIU {

    private String description;
    private DtoCustomer customer;
}
