package com.example.reminder.Reminder;

import org.springframework.stereotype.Service;


import java.time.LocalDate;

import java.util.List;

@Service
public class ReminderServices {
  private LocalDate localDate=LocalDate.now();
    private final long endDey=15;
    private final ReminderRepository reminderRepository;
    private final ReminderMapper reminderMapper;

    public ReminderServices(ReminderRepository reminderRepository, ReminderMapper reminderMapper) {
        this.reminderRepository = reminderRepository;
        this.reminderMapper = reminderMapper;
    }
    ReminderDto save(ReminderDto dto){
        Reminder meeting = reminderMapper.map(dto);
        Reminder save = reminderRepository.save(meeting);
        return reminderMapper.map(save);
    }
   public List<ReminderDto>findAllMeetingByDey(){
        return reminderRepository.findByLocalDate(localDate)
                .stream().map(reminderMapper::map).toList();


    }
}
