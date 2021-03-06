package com.bridgelabz.greetingcontroller.services;

import com.bridgelabz.greetingcontroller.model.Greeting;
import com.bridgelabz.greetingcontroller.model.User;
import com.bridgelabz.greetingcontroller.user.UserDto;

import java.util.List;


public interface IGreetingService {
    Greeting greetingMessage();
    String greetingMessageByName(UserDto userDto);
    Greeting addGreeting(User user);
    Greeting findGreetingById(long id);
    List<Greeting> getAllGreetings();
    Greeting editGreeting(Greeting greeting);
    String deleteMessageById(long id);
}