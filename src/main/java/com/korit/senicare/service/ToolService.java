package com.korit.senicare.service;

import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.request.tool.PostToolRequestDto;
import com.korit.senicare.dto.response.ResponseDto;

public interface ToolService {

    ResponseEntity<ResponseDto> postTool(PostToolRequestDto dto);

}
