package com.felipe.hexagonal.application.ports.in;

import com.felipe.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    void insert(Customer customer, String zipCode);

}
