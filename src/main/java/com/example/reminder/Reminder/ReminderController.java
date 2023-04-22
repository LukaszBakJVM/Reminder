package com.example.reminder.Reminder;


import com.example.reminder.EmailSender.MailServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/remind")
public class ReminderController {
    private final ReminderServices services;
    private final MailServices mailServices;

    public ReminderController(ReminderServices services, MailServices mailServices) {
        this.services = services;
        this.mailServices = mailServices;
    }

    @GetMapping()
    ResponseEntity<List<ReminderDto>> allMeetingByDey() {
        mailServices.sendEmail();
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