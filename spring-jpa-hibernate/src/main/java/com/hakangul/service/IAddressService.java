package com.hakangul.service;

import com.hakangul.dto.DtoAddress;

public interface IAddressService {

    public DtoAddress findAddressById(Long id);
}
