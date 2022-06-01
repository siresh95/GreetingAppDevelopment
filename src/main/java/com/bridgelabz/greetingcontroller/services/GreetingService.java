package com.bridgelabz.greetingcontroller.services;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.bridgelabz.greetingcontroller.model.Greeting;
import com.bridgelabz.greetingcontroller.model.User;
import com.bridgelabz.greetingcontroller.repositary.IGreetingRepository;
import com.bridgelabz.greetingcontroller.user.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingRepository greetingRepository;

    @Override
    public Greeting greetingMessage() {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }

    @Override
    public String greetingMessageByName(UserDto userDto) {
        User user = new User();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(userDto, user);
        return ("Hello " + user.getFirstName() + " " + user.getLastName());
    }

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting findGreetingById(long id) {
        return greetingRepository.findById(id).get();

    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting editGreeting(Greeting greeting) {
        return greetingRepository.save(new Greeting(2, "BridgeLabz Updated..."));
    }
}