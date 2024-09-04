package com.aeon.library.configs;

import com.aeon.library.borrower.BorrowerRepository;
import com.aeon.library.borrower.usecase.RegisterBorrower;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public RegisterBorrower registerBorrower(
            BorrowerRepository borrowerRepository
    ) {
        return new RegisterBorrower(borrowerRepository);
    }
}
