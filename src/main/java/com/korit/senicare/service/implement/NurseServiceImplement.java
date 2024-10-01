package com.korit.senicare.service.implement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.senicare.common.object.ChargedCustomer;
import com.korit.senicare.dto.request.nurse.PatchNurseRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.nurse.GetChargedCustomerResponseDto;
import com.korit.senicare.dto.response.nurse.GetNurseListResponseDto;
import com.korit.senicare.dto.response.nurse.GetNurseResponseDto;
import com.korit.senicare.dto.response.nurse.GetSignInResponseDto;
import com.korit.senicare.entity.CustomerEntity;
import com.korit.senicare.entity.NurseEntity;
import com.korit.senicare.repository.CustomerRepository;
import com.korit.senicare.repository.NurseRepository;
import com.korit.senicare.service.NurseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NurseServiceImplement implements NurseService {

    private final NurseRepository nurseRepository;
    private final CustomerRepository customerRepository;

    @Override
    public ResponseEntity<? super GetSignInResponseDto> getSignIn(String userId) {

        NurseEntity nurseEntity = null;

        try {

            nurseEntity = nurseRepository.findByUserId(userId);
            if (nurseEntity == null) return ResponseDto.noExistUserId();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInResponseDto.success(nurseEntity);

    }

    @Override
    public ResponseEntity<? super GetNurseListResponseDto> getNurseList() {

        List<NurseEntity> nurseEntities = new ArrayList<>();

        try {

            nurseEntities = nurseRepository.findAll();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetNurseListResponseDto.success(nurseEntities);

    }

    @Override
    public ResponseEntity<? super GetNurseResponseDto> getNurse(String userId) {
        NurseEntity nurseEntity = null;

        try {

            nurseEntity = nurseRepository.findByUserId(userId);
            if (nurseEntity == null) return ResponseDto.noExistUserId();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetNurseResponseDto.success(nurseEntity);
    }

    @Override
    public ResponseEntity<ResponseDto> patchNurse(PatchNurseRequestDto dto, String userId) {

        try {

            String name = dto.getName();

            NurseEntity nurseEntity = nurseRepository.findByUserId(userId);
            if (nurseEntity == null) return ResponseDto.noExistUserId();
            nurseEntity.setName(name);

            nurseRepository.save(nurseEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetChargedCustomerResponseDto> getChargedCustomer(String nurseId) {

        List<CustomerEntity> customerEntities = new ArrayList<>();

        try {

            customerEntities = customerRepository.findByCharger(nurseId);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetChargedCustomerResponseDto.success(customerEntities);

    }

}
