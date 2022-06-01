package com.bridgelabz.greetingcontroller;



import java.util.concurrent.atomic.AtomicLong;

import com.bridgelabz.greetingcontroller.model.Greeting;
import com.bridgelabz.greetingcontroller.services.IGreetingService;
import org.springframework.stereotype.Service;


@Service
class GreetingService  implements IGreetingService {
    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();


    @Override
    public Greeting greetingMessage() {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }
}