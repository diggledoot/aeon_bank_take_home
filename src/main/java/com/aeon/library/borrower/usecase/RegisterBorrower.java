package com.aeon.library.borrower.usecase;

import com.aeon.library.borrower.data.BorrowerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterBorrower {
    private final BorrowerRepository borrowerRepository;

    public void execute(String name, String email) {
        borrowerRepository.register(name, email);
    }
}
