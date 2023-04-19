package com.example.reminder.Reminder;

import com.example.reminder.Exection.NotFoundException;
import com.example.reminder.Person.Person;
import com.example.reminder.Person.PersonRepository;

import org.springframework.stereotype.Service;


import java.time.LocalDate;


@Service
public class ReminderMapper {
    public final PersonRepository personRepository;

    public ReminderMapper(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    Reminder map(ReminderDto dto){
        Reminder reminder =new Reminder();
        reminder.setId(dto.getId());
        reminder.setStartMeeting(dto.getStartMeeting());
        reminder.setDurationMeeting(dto.getDurationMeeting());
        LocalDate localDate=dto.getStartMeeting().toLocalDate();
        reminder.setLocalDate(localDate);
        Person person = personRepository.findById(dto.getPersonId())
                .orElseThrow(() -> new NotFoundException("Brak Uzytkoenike,dodaj go do bazy"));
        reminder.setPerson(person);
        return reminder;
    }
    ReminderDto map(Reminder reminder){
        ReminderDto dto =new ReminderDto();
        dto.setId(reminder.getId());
        dto.setStartMeeting(reminder.getStartMeeting());
        dto.setDurationMeeting(reminder.getDurationMeeting());
        LocalDate localDate = reminder.getStartMeeting().toLocalDate();
        dto.setDay(localDate);
        dto.setPersonId(reminder.getPerson().getId());
        return dto;
    }
}
