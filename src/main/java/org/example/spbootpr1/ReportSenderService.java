package org.example.spbootpr1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class ReportSenderService {

    @Async
    public void sendReport(String message) {

        try {
            TimeUnit.SECONDS.sleep(5);
            //sent message to gmail
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Sending message!!!!");
        //ataylab uyushtirilgan xato!!!
        throw new RuntimeException("Something went wrong!!!!!!!!");
    }





}
