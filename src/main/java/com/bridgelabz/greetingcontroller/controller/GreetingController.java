package com.bridgelabz.greetingcontroller.controller;


import java.util.concurrent.atomic.AtomicLong;

import com.bridgelabz.greetingcontroller.model.Greeting;
import com.bridgelabz.greetingcontroller.model.User;
import com.bridgelabz.greetingcontroller.services.IGreetingService;
import com.bridgelabz.greetingcontroller.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping(value = { "/greeting", "/greeting/", "/greeting/home" })
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    @GetMapping("greeting/{name}")
    public Greeting greetings(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    private IGreetingService greetingService;

    /**
     * localhost:8080/greeting/service
     *
     * @return={id =1 , content="hello world!}
     */
    @GetMapping("greeting/service")
    public Greeting greetings() {
        return greetingService.greetingMessage();
    }

    @PostMapping("/greeting")
    public String greetingMessage(@RequestBody UserDto userDto) {
        return greetingService.greetingMessageByName(userDto);
    }
    /* Used add method to store on Repository.
     *
     */
    @GetMapping("/greetings")
    public Greeting greetingdata(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }
    @GetMapping("/greetingdata/{id}")
    public Greeting findGreetingById(@PathVariable long id) {
        return greetingService.findGreetingById(id);
    }
}