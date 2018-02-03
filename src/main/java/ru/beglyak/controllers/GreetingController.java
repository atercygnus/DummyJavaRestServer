package ru.beglyak.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.beglyak.model.Goodbye;
import ru.beglyak.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(path = "/goodbye", method = RequestMethod.GET)
    public Goodbye goodbye(@RequestParam(value="name", defaultValue="dummy") String name) {
        return new Goodbye(counter.incrementAndGet(),
                String.format(template, name));
    }
}
