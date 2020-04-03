package com.kar.springbootconfigdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting: default value}")
    private String greetingMessage;

    @Value("Some static message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Value("#{${dbValues}}")
    private Map<String, String> dbValues;

    @GetMapping("/greeting")
    public String greeting(){
        return greetingMessage + " " + staticMessage + " " + listValues + "\n"
                + dbValues.get("connectionString") + " " + dbValues.get("userName") + " " + dbValues.get("password");
    }
}
