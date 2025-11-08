package io.github.uazw.helloworld.controller;

import org.springframework.stereotype.Service;

@Service
public class AService {

    public void serve() {
        System.out.println("AService is serving.");
    }
}
