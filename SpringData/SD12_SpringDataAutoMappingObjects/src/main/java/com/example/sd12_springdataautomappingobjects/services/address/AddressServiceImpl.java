package com.example.sd12_springdataautomappingobjects.services.address;

import com.example.sd12_springdataautomappingobjects.entities.Address;
import com.example.sd12_springdataautomappingobjects.entities.dtos.AddressDTO;
import com.example.sd12_springdataautomappingobjects.repositories.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper mapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper mapper) {
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }


    @Override
    public Address create(AddressDTO data) {

        Address address = mapper.map(data, Address.class);

        return this.addressRepository.save(address);
    }
}
