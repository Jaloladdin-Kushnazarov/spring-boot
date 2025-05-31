package org.example.spbootpr1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class Spbootpr1Application {
//bu buyruq terminal orqali dev, prod va test configuratsiyalarni alohida run qilish uchun ishlatilinadi
//    java -Dspring.profiles.active=prod -Dserver.port=9090 -jar springbootpr1-0.0.1-SNAPSHOT.jar
    
    public static void main(String[] args) {
        SpringApplication.run(Spbootpr1Application.class, args);
    }



//    @Bean
//    @Profile("dev")
//    public TaskExecutor taskExecutorDev() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(2);
//        executor.setMaxPoolSize(10);
//        executor.setQueueCapacity(10);
//        executor.setThreadNamePrefix("dev-");
//        executor.initialize();
//        return executor;
//    }
//
//
//    @Bean
//    @Profile("test")
//    public TaskExecutor taskExecutorTest() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(2);
//        executor.setMaxPoolSize(5);
//        executor.setQueueCapacity(10);
//        executor.setThreadNamePrefix("test-");
//        executor.initialize();
//        return executor;
//    }
//    @Bean
//    @Profile("prod")
//    public TaskExecutor taskExecutorProd() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(10);
//        executor.setMaxPoolSize(100);
//        executor.setQueueCapacity(100);
//        executor.setThreadNamePrefix("prod  -");
//        executor.initialize();
//        return executor;
//    }
}
