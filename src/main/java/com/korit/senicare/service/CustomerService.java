package com.korit.senicare.service;

import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.request.customer.PostCustomerRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.customer.GetCustomerListResponseDto;
import com.korit.senicare.dto.response.customer.GetCustomerResponseDto;

public interface CustomerService {

    ResponseEntity<ResponseDto> postCustomer(PostCustomerRequestDto dto);
    ResponseEntity<? super GetCustomerListResponseDto> getCustomerList();
    ResponseEntity<? super GetCustomerResponseDto> getCustomer(Integer customerNumber);

}
