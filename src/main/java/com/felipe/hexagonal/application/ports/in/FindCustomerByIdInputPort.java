package com.felipe.hexagonal.application.ports.in;

import com.felipe.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
