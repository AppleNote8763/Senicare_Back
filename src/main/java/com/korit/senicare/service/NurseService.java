package com.korit.senicare.service;

import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.request.nurse.PatchNurseRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.nurse.GetChargedCustomerResponseDto;
import com.korit.senicare.dto.response.nurse.GetNurseListResponseDto;
import com.korit.senicare.dto.response.nurse.GetNurseResponseDto;
import com.korit.senicare.dto.response.nurse.GetSignInResponseDto;

public interface NurseService {

    ResponseEntity<? super GetSignInResponseDto> getSignIn(String userId);
    ResponseEntity<? super GetNurseResponseDto> getNurse(String userId);
    ResponseEntity<? super GetNurseListResponseDto> getNurseList();
    ResponseEntity<ResponseDto> patchNurse(PatchNurseRequestDto dto, String userId);
    ResponseEntity<? super GetChargedCustomerResponseDto> getChargedCustomer(String nurseId);

}
