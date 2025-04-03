package org.example.spbootpr1.controller;

import lombok.RequiredArgsConstructor;
import org.example.spbootpr1.entity.Mail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final Mail mail;

    @Value("${welcome.message}")
    String message;

    @GetMapping
    public String goHomePage(Model model) {
    model.addAttribute("mail", mail);
    model.addAttribute("message", message);
    return "home";
    }

}
