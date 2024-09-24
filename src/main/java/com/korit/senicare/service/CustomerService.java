package com.korit.senicare.service;

import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.request.customer.PostCustomerRequestDto;
import com.korit.senicare.dto.response.ResponseDto;

public interface CustomerService {

    ResponseEntity<ResponseDto> postCustomer(PostCustomerRequestDto dto);

}
