package com.aeon.library.configs;

import com.aeon.library.borrower.BorrowerRepository;
import com.aeon.library.borrower.BorrowerRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AdapterConfig {

    @Bean
    public BorrowerRepository borrowerRepository(
            JdbcTemplate jdbcTemplate
    ) {
        return new BorrowerRepositoryImpl(jdbcTemplate);
    }
}
