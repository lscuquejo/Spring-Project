package com.training.app.ws.exceptions;

public class AccountServiceExcepetion extends RuntimeException {
    private static final long serialVersionUID = 2305497558108595499L;

    public AccountServiceExcepetion(String message)
    {
        super(message);
    }
}