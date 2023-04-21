package com.example.reminder.EmailSender;

import com.example.reminder.Reminder.ReminderDto;
import com.example.reminder.Reminder.ReminderServices;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServices {
    private final JavaMailSender mailSender;
    private final ReminderServices reminderServices;

    public MailServices(JavaMailSender mailSender, ReminderServices reminderServices) {
        this.mailSender = mailSender;
        this.reminderServices = reminderServices;
    }
    public void sendEmail() {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("bbzzyyczczeek@interia.pl");
        mail.setSubject("Testing Mail API");
       reminderServices.findAllMeetingByDey().stream().toList().forEach(System.out::println);




        mail.setText("s");


        mailSender.send(mail);
    }
}
