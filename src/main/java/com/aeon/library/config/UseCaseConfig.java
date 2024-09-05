package com.aeon.library.config;

import com.aeon.library.borrower.data.BorrowerRepository;
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
