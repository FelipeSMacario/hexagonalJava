package com.felipe.hexagonal.application.core.usecase;

import com.felipe.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.felipe.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.felipe.hexagonal.application.ports.out.DeleteCustomerOutPutPort;

public class DeleteCustomerByIdUserCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerOutPutPort deleteCustomerOutPutPort;

    public DeleteCustomerByIdUserCase(FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerOutPutPort deleteCustomerOutPutPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerOutPutPort = deleteCustomerOutPutPort;
    }

    @Override
    public void delete(String id){
        var customer = findCustomerByIdInputPort.find(id);
        deleteCustomerOutPutPort.delete(id);
    }
}
