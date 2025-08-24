package com.hakangul.controller;

import java.util.List;

import com.hakangul.dto.DtoAddress;
import com.hakangul.dto.IU.DtoAddressIU;

public interface IAddressController {

    public DtoAddress saveAddress(DtoAddressIU dtoAddress);

    public List<DtoAddress> findAllAddresses();

    public DtoAddress findAddressById(Long id);

    public void deleteAddressById(Long id);

    public DtoAddress updateAddress(Long id, DtoAddressIU dtoAddress);
}
