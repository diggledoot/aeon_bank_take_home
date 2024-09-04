package com.aeon.library.borrower;

import com.aeon.library.LibraryException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
public class BorrowerRepositoryImpl implements BorrowerRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void register(String name, String email) {
        String sql = "INSERT INTO borrower (name, email) VALUES (?,?)";
        try {
            jdbcTemplate.update(sql, name, email);
        } catch (DataAccessException e) {
            throw new LibraryException(e.getMessage(), e);
        }
    }
}
