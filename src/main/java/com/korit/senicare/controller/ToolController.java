package com.korit.senicare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korit.senicare.dto.request.tool.PostToolRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.service.ToolService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tool")
@RequiredArgsConstructor
public class ToolController {

    private final ToolService toolService;

    @PostMapping(value = {"", "/"})
    public ResponseEntity<ResponseDto> postTool(
        @RequestBody @Valid PostToolRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = toolService.postTool(requestBody);
        return response;
    }

}
