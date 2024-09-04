package com.aeon.library.borrower;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Borrower {
    UUID id;
    String name;
    String email;
}
