package com.felipe.hexagonal.application.ports.out;

import com.felipe.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}
