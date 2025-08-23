package com.hakangul.controller;

import com.hakangul.dto.DtoCustomer;



public interface ICustomerController {

    public  DtoCustomer findCustomerById(Long id);
}
