package com.felipe.hexagonal.application.ports.out;

import com.felipe.hexagonal.application.core.domain.Customer;

public interface DeleteCustomerOutPutPort {
    void delete(String id);
}
