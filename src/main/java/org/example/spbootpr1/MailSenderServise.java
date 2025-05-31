package org.example.spbootpr1;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailSenderServise {
    private final JavaMailSender javaMailSender;

    @Async
    public void sendSimpleMail(String username) {
        try {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mimeMessage.setFrom("from@gmail.com");
        mimeMessage.setRecipients(MimeMessage.RecipientType.TO, "to@gmail.com");
        mimeMessage.setSubject("subject from Test simple     mail");
        mimeMessage.setText    ("Hello From PDP Online ");
        javaMailSender.send(mimeMessage);
        }catch (MessagingException e){
            e.printStackTrace();
        }
    }
}
