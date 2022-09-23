package org.ec.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ExampleController {

    @GetMapping
    public String hello() {
        return "index.html";
    }
}
