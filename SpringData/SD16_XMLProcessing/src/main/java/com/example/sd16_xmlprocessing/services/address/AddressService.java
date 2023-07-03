package com.example.sd16_xmlprocessing.services.address;

import com.example.sd16_xmlprocessing.entities.Address;
import com.example.sd16_xmlprocessing.entities.dtos.AddressDTO;

public interface AddressService {

    Address create(AddressDTO data);

}
