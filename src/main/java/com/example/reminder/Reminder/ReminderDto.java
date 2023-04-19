package com.example.reminder.Reminder;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReminderDto {
    private long id;
    private LocalDateTime startMeeting;
    private long durationMeeting;
    private LocalDate day;

    private long personId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartMeeting() {
        return startMeeting;
    }

    public void setStartMeeting(LocalDateTime startMeeting) {
        this.startMeeting = startMeeting;
    }

    public long getDurationMeeting() {
        return durationMeeting;
    }

    public void setDurationMeeting(long durationMeeting) {
        this.durationMeeting = durationMeeting;
    }



    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
