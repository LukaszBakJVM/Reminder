package com.example.reminder.Person;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/p")
public class PersonController {
    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @PostMapping
    ResponseEntity<PersonAddressDto>save(@RequestBody PersonAddressDto dto){
        PersonAddressDto save = personServices.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);

    }
    @GetMapping("/{name}")
    ResponseEntity<PersonAddressDto>findByName(@PathVariable String name){
        return ResponseEntity.ok(personServices.findPersonByLastName(name));
    }
}
