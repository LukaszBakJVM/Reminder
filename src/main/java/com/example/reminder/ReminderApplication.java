package com.example.reminder;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ReminderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ReminderApplication.class, args);



    }
}

