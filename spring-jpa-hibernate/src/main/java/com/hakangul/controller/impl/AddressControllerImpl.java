package com.hakangul.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hakangul.controller.IAddressController;
import com.hakangul.dto.DtoAddress;
import com.hakangul.dto.IU.DtoAddressIU;
import com.hakangul.service.IAddressService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/rest/api/address")
public class AddressControllerImpl implements IAddressController {

    @Autowired
    private IAddressService addressService;



    @GetMapping(path ="/{id}")
    @Override
    public DtoAddress findAddressById(@PathVariable Long id) {
        return addressService.findAddressById(id);
    }



    @PostMapping(path = "/save")
    @Override
    public DtoAddress saveAddress(@RequestBody @Valid DtoAddressIU dtoAddressIU) {
        return addressService.saveAddress(dtoAddressIU);
    }



    @GetMapping(path ="/list")
    @Override
    public List<DtoAddress> findAllAddresses() {
        return addressService.findAllAddress();
    }



    @DeleteMapping(path = "/{id}")
    @Override
    public void deleteAddressById(@PathVariable Long id) {
        addressService.deleteAddressById(id);
    }

    @PutMapping("/{id}")
    @Override
    public DtoAddress updateAddress(@PathVariable Long id, @RequestBody DtoAddressIU dtoAddress) {
        return addressService.updateAddress(id, dtoAddress);
    }

}
