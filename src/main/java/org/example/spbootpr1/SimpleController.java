package org.example.spbootpr1;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SimpleController {


    private final ReportSenderService reportSenderService;

    @GetMapping("/sendReort")
    public String sendReport() {
        reportSenderService.sendReport("Test uchun");
        return "Send report successfully!";
    }

}
