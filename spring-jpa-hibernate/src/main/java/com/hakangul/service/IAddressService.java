package com.hakangul.service;

import java.util.List;

import com.hakangul.dto.DtoAddress;
import com.hakangul.dto.IU.DtoAddressIU;

public interface IAddressService {

    public DtoAddress findAddressById(Long id);

    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);

    public List<DtoAddress> findAllAddress();

    public void deleteAddressById(Long id);

    public DtoAddress updateAddress(Long id, DtoAddressIU dtoAddressIU);

}
