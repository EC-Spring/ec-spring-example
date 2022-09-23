package org.ec.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ExampleRestController {

    @GetMapping
    public Hello hello() {
        return new Hello();
    }
}
