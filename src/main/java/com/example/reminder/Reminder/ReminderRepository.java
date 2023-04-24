package com.example.reminder.Reminder;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

import java.util.List;

public interface ReminderRepository extends CrudRepository<Reminder,Long> {

    List<Reminder>findByLocalDateOrderByStartMeetingAsc(LocalDate localDate);
}
