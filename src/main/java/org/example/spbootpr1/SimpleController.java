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
@RequestMapping("/api/example")
public class SimpleController {

    private final PersonProperties personProperties;

    @Value("${example.string:'Default Message(Learn Java In PDP)'}")
    private String exampleMessage;

    @Value("${example.language}")
    private List<String> exampleLanguages;

    @Value ("#{${example.numbers}}")
    private Map<String, String> exampleNumbers;




    @GetMapping("/message")
    public String getExampleMessage() {
        return exampleMessage;
    }


    @GetMapping("/languages")
    public List<String> getExampleLanguages() {
        return exampleLanguages;
    }


    @GetMapping("/numbers")
    public Map<String, String> getExampleNumbers() {
        return exampleNumbers;
    }


    @GetMapping("/person")
    public Person getPerson() {
        return personProperties.getPerson();
    }


}
