package com.example.reminder.Address;

import org.springframework.stereotype.Service;

@Service
public class AddressServices {
    private final AddressRepository repository;

    public AddressServices(AddressRepository repository) {
        this.repository = repository;
    }




}
