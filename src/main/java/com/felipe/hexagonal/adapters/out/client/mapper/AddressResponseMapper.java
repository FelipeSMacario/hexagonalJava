package com.felipe.hexagonal.adapters.out.client.mapper;

import com.felipe.hexagonal.adapters.out.client.response.AddressResponse;
import com.felipe.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
