

package io.github.uazw.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private AService aService;

    public HelloController(AService aService) {
        this.aService = aService;

    }

    @GetMapping
    public String hello() {
        aService.serve();
        return "hello";
    }
}