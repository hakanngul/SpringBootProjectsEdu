package com.hakangul.service;

import com.hakangul.dto.DtoCustomer;

public interface ICustomerService {


    public DtoCustomer findCustomerById(Long id);
    
}
