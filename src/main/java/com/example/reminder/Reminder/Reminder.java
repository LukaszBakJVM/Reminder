package com.example.reminder.Reminder;


import com.example.reminder.Person.Person;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate localDate;
    private LocalDateTime startMeeting;



    @ManyToOne
    private Person person;

    public Reminder() {
    }

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





    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
