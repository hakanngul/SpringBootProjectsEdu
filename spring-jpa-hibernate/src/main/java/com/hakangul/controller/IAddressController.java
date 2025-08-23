package com.hakangul.controller;

import com.hakangul.dto.DtoAddress;

public interface IAddressController {

    public DtoAddress findAddressById(Long id);
}
