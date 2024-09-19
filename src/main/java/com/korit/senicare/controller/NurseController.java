package com.korit.senicare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korit.senicare.service.NurseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/nurse")
@RequiredArgsConstructor
public class NurseController {

    private final NurseService nurseService;

}
