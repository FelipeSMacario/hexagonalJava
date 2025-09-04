package com.felipe.hexagonal.adapters.out.repository.mapper;

import com.felipe.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.felipe.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customer);
}
