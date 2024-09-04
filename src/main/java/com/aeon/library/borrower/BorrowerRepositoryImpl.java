package com.aeon.library.borrower;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
public class BorrowerRepositoryImpl implements BorrowerRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void register(String name, String email) {
        String sql = "INSERT INTO borrower (name, email) VALUES (?,?)";
        jdbcTemplate.update(sql, name, email);
    }
}
