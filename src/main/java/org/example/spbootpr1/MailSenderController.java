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
}