package com.felipe.hexagonal.application.core.usecase;

import com.felipe.hexagonal.application.core.domain.Customer;
import com.felipe.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.felipe.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.felipe.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.felipe.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUserCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUserCase(FindCustomerByIdInputPort findCustomerByIdInputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode){
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
