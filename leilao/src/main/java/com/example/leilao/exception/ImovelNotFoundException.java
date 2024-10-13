package com.example.leilao.exception;

public class ImovelNotFoundException extends RuntimeException {
    public ImovelNotFoundException(String message) {
        super(message);
    }
}
