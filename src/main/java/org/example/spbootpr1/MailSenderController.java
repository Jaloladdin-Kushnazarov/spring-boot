package org.example.spbootpr1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class MailSenderController {

//    private final MailSenderServise mailSenderServise;

    @PostMapping("/simple-mail")
    public String sendSimpleMessage(@RequestParam String username) {
//        for (int i = 0; i < 1000; i++) {
            log.info("simple mail sent username={} | Time: {}", username, new Date());
//        }
//        mailSenderServise.sendSimpleMail(username);
        return "Send Message !!!";
    }


    @PostMapping("/html-mail")
    public String sendHtmlMessage(@RequestParam String username) {
//        mailSenderServise.sendHtmlMail(username);
        if(new Random().nextBoolean()) {
            throw new RuntimeException("Error new for new Custom Appender");
        }else {
        log.info("simple mail sent username={} | Time: {}", username, new Date());
        }

        return "Send Message !!!";
    }


    @PostMapping("/html-attachment")
    public String sendAttachmentMessage(@RequestParam String username) {
//        mailSenderServise.sendAttachmentMail(username);
        return "Send Message !!!";
    }


    @PostMapping("/html-image")
    public String sendImageMessage(@RequestParam String username) {
//        mailSenderServise.sendImageMail(username);
        return "Send Message !!!";
    }


    @PostMapping("/html-freemaker")
    public String sendFreeMakerMessage(@RequestParam String username) {
//        mailSenderServise.sendFreeMakerMail(username);
        return "Send Message !!!";
    }

}