package com.example.reminder.Address;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address,Long> {
    Optional<Address>findByCityAndStreet(String city,String street);


}
