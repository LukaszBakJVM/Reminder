package com.example.reminder.Reminder;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/remind")
public class ReminderController {
    private final ReminderServices services;

    public ReminderController(ReminderServices services) {
        this.services = services;
    }

    @GetMapping()
    ResponseEntity<List<ReminderDto>> allMeetingByDey() {
        return ResponseEntity.ok(services.findAllMeetingByDey());
    }
@PostMapping
    ResponseEntity<ReminderDto> save(@RequestBody ReminderDto dto) {
        ReminderDto save = services.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }
}