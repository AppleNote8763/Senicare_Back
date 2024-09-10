package com.korit.senicare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 서버 장상작동 확인용
@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping("")
    public String main() {
        return "Server on...";
    }

}
