package com.felipe.hexagonal.adapters.out;

import com.felipe.hexagonal.adapters.out.repository.CustomerRepository;
import com.felipe.hexagonal.application.ports.out.DeleteCustomerOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomeAdapter implements DeleteCustomerOutPutPort {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void delete(String id) {

        customerRepository.deleteById(id);
    }
}
