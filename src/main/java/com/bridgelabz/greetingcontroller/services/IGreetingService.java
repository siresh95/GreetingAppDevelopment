package com.bridgelabz.greetingcontroller.services;

import com.bridgelabz.greetingcontroller.model.Greeting;
import com.bridgelabz.greetingcontroller.user.UserDto;



public interface IGreetingService {
    Greeting greetingMessage();
    String greetingMessageByName(UserDto userDto);

}