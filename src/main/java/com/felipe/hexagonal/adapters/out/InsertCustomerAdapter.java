package com.felipe.hexagonal.adapters.out;

import com.felipe.hexagonal.adapters.out.repository.CustomerRepository;
import com.felipe.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.felipe.hexagonal.application.core.domain.Customer;
import com.felipe.hexagonal.application.ports.out.InsertCustomerOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutPutPort {
    @Autowired
    private CustomerRepository customerrepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerrepository.save(customerEntity);
    }
}
