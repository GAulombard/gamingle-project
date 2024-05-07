package com.hodor.dotaapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    //todo replace this POC
    @GetMapping("/v1/hello")
    public ResponseEntity<String> hello(Authentication user) {
        log.debug("Connected as {}", user.getPrincipal());
        return ResponseEntity.ok("Hello World");
    }
}
