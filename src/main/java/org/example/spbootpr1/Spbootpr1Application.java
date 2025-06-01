package org.example.spbootpr1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Spbootpr1Application {

    
    public static void main(String[] args) {

//
//        class ClockTask extends TimerTask {
//            private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//            @Override
//            public void run() {
//                System.out.println("\r" + "Time is: " + dateFormat.format(new Date()));
//            }
//        }
//
//
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new ClockTask(),5000,1000);

        SpringApplication.run(Spbootpr1Application.class, args);
    }

}
