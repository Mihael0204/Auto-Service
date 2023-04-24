package com.example.backend.model;

public enum Status {
    ACCEPTED("Accepted"),
    PROCESS("In process"),
    SUCCESS("Success"),
    NOT_SUCCESS("Not success"),
    PAID("Paid");

    private final String value;

    Status(String value) {
        this.value = value;
    }
}
