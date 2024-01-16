package com.scaler.productservice.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final String tenplate = "Hello %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(tenplate, name));
    }

    @GetMapping("/say/{name}/{times}")
    public String sayHello(@PathVariable("name") String name,
                           @PathVariable("times") int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += "Hello " + name + "\n";
        }
        return result;
    }
}
