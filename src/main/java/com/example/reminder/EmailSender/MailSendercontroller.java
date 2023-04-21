package com.example.reminder.EmailSender;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailSendercontroller {
    private final MailServices mailServices;



    public MailSendercontroller(MailServices mailServices) {
        this.mailServices = mailServices;

    }

@GetMapping
public String send(){
        String email="bbzzl";
        mailServices.sendEmail();
        return "all ok";

}

  /*  @GetMapping
    ResponseEntity<List<ReminderDto>>mettin(){
        return ResponseEntity.ok(mailSender.sendEmail());
    }*/
}

