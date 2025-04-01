package com.vikas.JpaManyToMany.CustomException;

public class AddressNotFoundExeception extends Exception {
    public AddressNotFoundExeception(String message) {
        super("Address not Found");
    }
}
