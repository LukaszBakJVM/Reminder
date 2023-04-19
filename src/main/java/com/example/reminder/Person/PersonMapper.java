package com.example.reminder.Person;

import com.example.reminder.Address.Address;
import com.example.reminder.Address.AddressRepository;

import org.springframework.stereotype.Service;


@Service
public class PersonMapper {
    private final AddressRepository repository;

    public PersonMapper(AddressRepository repository) {
        this.repository = repository;
    }

    Person map(PersonAddressDto dto){
        Address address =new Address();
        Person person =new Person();
        person.setId(dto.getId());
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setTelephone(dto.getTelephone());
        person.setCompany(dto.getCompany());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
       // Address save = repository.save(address);
        person.setAddress(address);
        return person;
    }
    PersonAddressDto map (Person person){
        PersonAddressDto dto =new PersonAddressDto();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setTelephone(person.getTelephone());
        dto.setCompany(person.getCompany());
        dto.setCity(person.getAddress().getCity());
        dto.setStreet(person.getAddress().getStreet());
        return dto;

    }
}
