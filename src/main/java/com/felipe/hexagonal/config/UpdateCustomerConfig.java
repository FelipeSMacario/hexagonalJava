package com.felipe.hexagonal.config;

import com.felipe.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.felipe.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.felipe.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import com.felipe.hexagonal.application.core.usecase.UpdateCustomerUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUserCase updateCustomerUseCase(
            FindCustomerByIdUserCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUserCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}
