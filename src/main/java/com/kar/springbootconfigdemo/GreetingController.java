package com.kar.springbootconfigdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    @Autowired
    private Environment environment;

    /*
    @Value("#{${dbValues}}")
    private Map<String, String> dbValues;
     */

    @Autowired
    private DbSettings dbSettings;

    @GetMapping("/greeting")
    public String greeting(){
        return greetingMessage + " " + staticMessage + " " + listValues + "\n" +
                dbSettings.getConnection().get("connectionString") + " " +
                dbSettings.getConnection().get("userName") + " " +
                dbSettings.getConnection().get("password") + " " +
                dbSettings.getHost() + " " +
                dbSettings.getPort();

    }

    @GetMapping("/envdetails")
    public String getEnvDetails(){
        return environment.toString();
    }
}
