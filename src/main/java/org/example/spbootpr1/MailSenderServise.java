package org.example.spbootpr1;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class MailSenderServise {
    private final JavaMailSender javaMailSender;
    private final Configuration configuration;

    @Async
    public void sendSimpleMail(String username) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setFrom("from@gmail.com");
            mimeMessage.setRecipients(MimeMessage.RecipientType.TO, "to@gmail.com");
            mimeMessage.setSubject("subject from Test simple     mail");
            mimeMessage.setContent("<h1 style='color: red;'>Hello From PDP Online</h1>", "text/html");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendHtmlMail(String username) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setFrom("from@gmail.com");
            mimeMessage.setRecipients(MimeMessage.RecipientType.TO, "to@gmail.com");
            mimeMessage.setSubject("subject from Test simple mail");
            Path path = Path.of("src/main/resources/activate.html");
            String htmlContent = Files.readString(path);
            htmlContent    = htmlContent.formatted(username);
            mimeMessage.setContent(htmlContent, "text/html");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }



    @Async
    public void sendAttachmentMail(String username) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(username + "@gmail.com");
            mimeMessageHelper.setTo("to@gmail.com"  );
            mimeMessageHelper .setSubject("subject from Test simple mail");
            Path path = Path.of("src/main/resources/activate.html");
            Path imgPath = Path.of("src/main/resources/awq.jpg");
            Path pdfPath = Path.of("src/main/resources/Java_Developer_Level_Roadmap.pdf");
            FileSystemResource imgSystemResource = new FileSystemResource(imgPath);
            FileSystemResource pdfSystemResource = new FileSystemResource(pdfPath);
            String htmlContent = Files.readString(path);
            htmlContent    = htmlContent.formatted(username);
            mimeMessageHelper.setText(htmlContent, true);
            mimeMessageHelper.addAttachment("Nature.jpg", imgSystemResource);
            mimeMessageHelper.addAttachment("Java_Developer_Level_Roadmap.pdf", pdfSystemResource);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendImageMail(String username) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(username + "@gmail.com");
            mimeMessageHelper.setTo("to@gmail.com"  );
            mimeMessageHelper .setSubject("subject from Test simple mail");

            Path path = Path.of("src/main/resources/image.html");
            Path imgPath = Path.of("src/main/resources/awq.jpg");
//            Base64.Encoder encoder = Base64.getEncoder();
//            String imageAsBase64 = encoder.encodeToString(Files.readAllBytes(imgPath));

               String htmlContent = Files.readString(path);
//            htmlContent = htmlContent.formatted(imageAsBase64 );
            mimeMessageHelper.setText(htmlContent, true);
            mimeMessageHelper.addInline("image_id", new FileSystemResource(imgPath  ));

            javaMailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }



    @Async
    public void sendFreeMakerMail(String username) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(username + "@gmail.com");
            mimeMessageHelper.setTo("to@gmail.com"  );
            mimeMessageHelper .setSubject("subject from Test simple mail");

            Path path = Path.of("src/main/resources/image.html");
            Path imgPath = Path.of("src/main/resources/awq.jpg");
            Template template = configuration.getTemplate("activate_account.ftlh");
            String token = Base64.getEncoder().encodeToString(username.getBytes());
            Map<String, String> objectModel = Map.of("username", username,  "token", token);
            String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, objectModel);
            mimeMessageHelper.setText(htmlContent, true); // true -> HTML format

            mimeMessageHelper.addInline("image_id", new FileSystemResource(imgPath  ));

            javaMailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }  catch (TemplateException ignored) {
        }
    }
}
