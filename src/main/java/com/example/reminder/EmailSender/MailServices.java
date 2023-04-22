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
        List<ReminderDto> allMeetingByDey = reminderServices.findAllMeetingByDey();

        SimpleMailMessage mail = new SimpleMailMessage();
        StringBuilder str=new StringBuilder();
        mail.setTo("bbzzyyczczeek@interia.pl");
        mail.setSubject("Testing Mail API");
        for (ReminderDto reminderDto : allMeetingByDey) {
            str.append(reminderDto);
            System.out.println(str.append(reminderDto.toString()));


            mail.setText(str.toString());

        }
        mailSender.send(mail);
    }
}
