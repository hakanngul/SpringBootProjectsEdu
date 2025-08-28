package com.hakangul.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hakangul.dto.DtoAddress;
import com.hakangul.dto.DtoCustomer;
import com.hakangul.dto.IU.DtoAddressIU;
import com.hakangul.entities.Address;
import com.hakangul.exception.AddressNotFoundException;
import com.hakangul.repository.AddressRepository;
import com.hakangul.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public DtoAddress findAddressById(Long id) {
        return addressRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        Address address = new Address();
        DtoAddress dtoAddress = new DtoAddress();
        BeanUtils.copyProperties(dtoAddressIU, address);
        Address dbAddress = addressRepository.save(address);
        BeanUtils.copyProperties(dbAddress, dtoAddress);
        return dtoAddress;
    }

    @Override
    public List<DtoAddress> findAllAddress() {
        List<DtoAddress> dtoList = new ArrayList<>();

        List<Address> addressList = addressRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));

        addressList.forEach(address -> {
            DtoAddress dtoAddress = new DtoAddress();
            BeanUtils.copyProperties(address, dtoAddress);
            dtoList.add(dtoAddress);
        });

        return dtoList;
    }

    @Override
    public void deleteAddressById(Long id) {
        addressRepository.findById(id)
        .ifPresentOrElse(
            addressRepository::delete,
            () -> {
                throw new AddressNotFoundException(id);
            }
        );
    }

    @Override
    public DtoAddress updateAddress(Long id, DtoAddressIU updateAddressIU) {
        System.out.println("Gelen Address: " + updateAddressIU.getDescription());
        return Optional.ofNullable(getAddress(id))
                .map(dbAddress -> {
                    // Update the entity with new values
                    dbAddress.setDescription(updateAddressIU.getDescription());

                    // Save the updated entity to database
                    Address savedAddress = addressRepository.save(dbAddress);

                    // Convert to DTO using consistent logic with findById
                    return convertToDto(savedAddress);
                })
                .orElseThrow(() -> new AddressNotFoundException(id));
    }

    private Address getAddress(Long id) {
        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    private DtoAddress convertToDto(Address address) {
        DtoAddress dtoAddress = new DtoAddress();
        BeanUtils.copyProperties(address, dtoAddress);

        // Customer bilgisini güvenli şekilde ekle
        if (address.getCustomer() != null) {
            DtoCustomer dtoCustomer = new DtoCustomer();
            dtoCustomer.setId(address.getCustomer().getId());
            dtoCustomer.setName(address.getCustomer().getName());
            dtoAddress.setCustomer(dtoCustomer);
        }

        return dtoAddress;
    }

}
