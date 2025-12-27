package com.cactus.schedule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        ScheduleService scheduleService = new ScheduleService();
        scheduleService.schedule(()->{
            System.out.println(LocalDateTime.now().format(dateTimeFormatter) +" delay 500 ms");
        },500);

        Thread.sleep(1000);
        System.out.println("task 2");
        scheduleService.schedule(()->{
            System.out.println(LocalDateTime.now().format(dateTimeFormatter) +" delay 1000 ms");
        },1000);
    }
}
