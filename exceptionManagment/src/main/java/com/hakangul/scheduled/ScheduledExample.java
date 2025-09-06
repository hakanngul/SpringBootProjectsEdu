package com.hakangul.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledExample {

    // * - * - * - * - * - *
    // saniye - dakika - saat - gün - ay - hafta - günü
    // @Scheduled(cron = "0 57 16 * * *") // every day at 16:57
    @Scheduled(cron = "*/5 * * * * *") // every 5 second..
    public void print1to10() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ". sayı");
        }
    }

}
