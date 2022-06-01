package com.bridgelabz.greetingcontroller.controller;


import java.util.concurrent.atomic.AtomicLong;

import com.bridgelabz.greetingcontroller.model.Greeting;
import com.bridgelabz.greetingcontroller.services.IGreetingService;
import com.bridgelabz.greetingcontroller.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * curl localhost:8080/greeting
     * @return={id =1 , content="hello world!}
     * localhost:8080/greeting?name=Shilpa
     * @return= { id=2,content="hello Shilpa!
     */
    @GetMapping(value = { "/greeting", "/greeting/", "/greeting/home" })
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /**
     * localhost:8080/greeting/Shilpa
     * @return={id =1 , content="hello Shilpa!}
     */
    @GetMapping("greeting/{name}")
    public Greeting greetings(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    private IGreetingService greetingService;

    /**
     * localhost:8080/greeting/service
     * @return={id =1 , content="hello world!}
     */
    @GetMapping("greeting/service")
    public Greeting greeting() {
        return greetingService.greetingMessage();

    }
    @PostMapping("/greeting")
    public String greetingMessage(@RequestBody UserDto userDto) {
        return greetingService.greetingMessageByName(userDto);
    }
}