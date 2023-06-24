package com.example.sd12_springdataautomappingobjects.services.address;

import com.example.sd12_springdataautomappingobjects.entities.Address;
import com.example.sd12_springdataautomappingobjects.entities.dtos.AddressDTO;

public interface AddressService {

    Address create(AddressDTO data);

}
