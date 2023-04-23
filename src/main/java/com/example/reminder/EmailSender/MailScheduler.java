package com.example.reminder.EmailSender;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MailScheduler {
    private final MailServices mailServices;

    public MailScheduler(MailServices mailServices) {
        this.mailServices = mailServices;
    }

   // @Scheduled(cron = "0 0 12 * * ?")

    @Scheduled(cron = "*/1 * * * *")

    public void sendEmail() {
        mailServices.sendEmail();

    }
}
