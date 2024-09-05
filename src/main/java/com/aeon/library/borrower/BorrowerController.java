package com.aeon.library.borrower;

import com.aeon.library.borrower.dto.RegisterBorrowerRequest;
import com.aeon.library.borrower.usecase.RegisterBorrower;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/borrower")
public class BorrowerController {
    private final RegisterBorrower registerBorrower;

    @PostMapping
    public ResponseEntity<?> register(
            @RequestBody RegisterBorrowerRequest registerBorrowerRequest
    ) {
        registerBorrowerRequest.isValidBorrower();
        registerBorrower.execute(registerBorrowerRequest.getName(), registerBorrowerRequest.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
