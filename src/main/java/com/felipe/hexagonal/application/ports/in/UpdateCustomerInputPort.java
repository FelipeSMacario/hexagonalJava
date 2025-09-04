package com.felipe.hexagonal.application.ports.in;

import com.felipe.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
