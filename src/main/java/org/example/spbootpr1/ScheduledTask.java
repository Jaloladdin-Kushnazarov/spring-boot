package org.example.spbootpr1;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Configuration
public class ScheduledTask {

//    @Scheduled(fixedDelay = 2, timeUnit = TimeUnit.SECONDS )
      public void fixedDelayTask() {
          System.out.println("(FixedDelayTask) Time is: " + System.currentTimeMillis());
      }


//    https://crontab.guru/

    @Scheduled(cron = "0 10 9 * JAN-MAR MON", zone = "Asia/Tashkent")
    @Scheduled(cron = "0 10-59/3 * * * Sun")
    @SneakyThrows
    public void everyDayAt9oclock() {
        System.out.println( LocalTime.now());
    }

}

