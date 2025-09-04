package com.felipe.hexagonal.application.core.usecase;

import com.felipe.hexagonal.application.core.domain.Customer;
import com.felipe.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.felipe.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.felipe.hexagonal.application.ports.out.InsertCustomerOutPutPort;
import com.felipe.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutPutPort insertCustomerOutPutPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutPutPort insertCustomerOutPutPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutPutPort = insertCustomerOutPutPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutPutPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }

}
