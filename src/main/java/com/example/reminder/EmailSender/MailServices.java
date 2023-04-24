package com.example.reminder.EmailSender;

import com.example.reminder.Person.PersonAddressDto;
import com.example.reminder.Person.PersonServices;
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
    private final PersonServices personServices;

    public MailServices(JavaMailSender mailSender, ReminderServices reminderServices, PersonServices personServices) {
        this.mailSender = mailSender;
        this.reminderServices = reminderServices;
        this.personServices = personServices;
    }
    public void sendEmail() {
        List<ReminderDto> allMeetingByDey = reminderServices.findAllMeetingByDey();

        SimpleMailMessage mail = new SimpleMailMessage();
        StringBuilder str=new StringBuilder();
        mail.setTo("bbzzyyczczeek@interia.pl");//recipient mail
        mail.setSubject("Dzisiejsze zaplanowane spotkania");
        for (ReminderDto reminderDto : allMeetingByDey) {
            PersonAddressDto byId = personServices.findById(reminderDto.getPersonId());

            str.append(reminderDto);
            str.append(byId);



            mail.setText(str.toString());

        }
        mailSender.send(mail);
    }
}
