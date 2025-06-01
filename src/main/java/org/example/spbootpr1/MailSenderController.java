package org.example.spbootpr1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class MailSenderController {

    private final MailSenderServise mailSenderServise;

    @PostMapping("/simple-mail")
    public String sendSimpleMessage(@RequestParam String username) {
        mailSenderServise.sendSimpleMail(username);
        return "Send Message !!!";
    }


    @PostMapping("/html-mail")
    public String sendHtmlMessage(@RequestParam String username) {
        mailSenderServise.sendHtmlMail(username);
        return "Send Message !!!";
    }


    @PostMapping("/html-attachment")
    public String sendAttachmentMessage(@RequestParam String username) {
        mailSenderServise.sendAttachmentMail(username);
        return "Send Message !!!";
    }


    @PostMapping("/html-image")
    public String sendImageMessage(@RequestParam String username) {
        mailSenderServise.sendImageMail(username);
        return "Send Message !!!";
    }


    @PostMapping("/html-freemaker")
    public String sendFreeMakerMessage(@RequestParam String username) {
        mailSenderServise.sendFreeMakerMail(username);
        return "Send Message !!!";
    }

}