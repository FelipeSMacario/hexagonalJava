package com.felipe.hexagonal.config;

import com.felipe.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.felipe.hexagonal.adapters.out.InsertCustomerAdapter;
import com.felipe.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.felipe.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfForValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);
    }

}
