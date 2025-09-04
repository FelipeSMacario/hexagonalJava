package com.felipe.hexagonal.config;

import com.felipe.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.felipe.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUserCase findCustomerByIdUseCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCustomerByIdUserCase(findCustomerByIdAdapter);
    }

}
