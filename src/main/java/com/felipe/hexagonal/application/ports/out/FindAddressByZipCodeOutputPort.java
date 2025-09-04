package com.felipe.hexagonal.application.ports.out;

import com.felipe.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
