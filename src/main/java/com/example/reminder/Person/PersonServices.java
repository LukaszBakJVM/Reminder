package com.example.reminder.Person;

import com.example.reminder.Exection.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonServices {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;


    public PersonServices(PersonRepository personRepository,PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;

    }

    PersonAddressDto save(PersonAddressDto dto){
        Person mapped = personMapper.map(dto);
        Person save = personRepository.save(mapped);
        return personMapper.map(save);
    }
    PersonAddressDto findPersonByLastName(String lastName){
        Person person = personRepository.findByLastName(lastName).orElseThrow(()->new NotFoundException("Brak uzytkoenieka"));
        return personMapper.map(person);

    }
}
