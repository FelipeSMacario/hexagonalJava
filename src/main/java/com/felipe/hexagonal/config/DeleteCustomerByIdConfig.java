package com.felipe.hexagonal.config;

import com.felipe.hexagonal.adapters.out.DeleteCustomeAdapter;
import com.felipe.hexagonal.application.core.usecase.DeleteCustomerByIdUserCase;
import com.felipe.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUserCase deleteCustomerByIdUseCase(
            FindCustomerByIdUserCase findCustomerByIdUseCase,
            DeleteCustomeAdapter deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUserCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }

}
