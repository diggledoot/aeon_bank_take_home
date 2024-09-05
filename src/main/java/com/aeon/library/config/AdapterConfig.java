package com.aeon.library.config;

import com.aeon.library.borrower.data.BorrowerRepository;
import com.aeon.library.borrower.data.BorrowerRepositoryImpl;
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
