package com.korit.senicare.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.korit.senicare.dto.response.ResponseDto;

// 예외 대처를 위한 REST API 처리

@RestControllerAdvice
public class CustomExceptionHandler {

    // HttpMessageNotReadableException : Request Body가 없어서 읽지 못할때
    // MethodArgumentNotValidException : 유효성 검사 실패
    @ExceptionHandler({
        HttpMessageNotReadableException.class,
        MethodArgumentNotValidException.class
    })
    public ResponseEntity<ResponseDto> validExceptionHandler(Exception exception) {
        exception.printStackTrace();
        return ResponseDto.validationFail();
    }

}
