package com.korit.senicare.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.senicare.common.util.AuthNumberCreator;
import com.korit.senicare.dto.request.auth.IdCheckRequestDto;
import com.korit.senicare.dto.request.auth.TelAuthRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.entity.TelAuthNumberEntity;
import com.korit.senicare.repository.NurseRepository;
import com.korit.senicare.repository.TelAuthNumberRepository;
import com.korit.senicare.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final NurseRepository nurseRepository;
    private final TelAuthNumberRepository telAuthNumberRepository;

    @Override
    public ResponseEntity<ResponseDto> icCheck(IdCheckRequestDto dto) {

        String userId = dto.getUserId();

        try {

            boolean isExistedId = nurseRepository.existsByUserId(userId);
            if (isExistedId) return ResponseDto.duplicatedUserId();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }

    @Override
    public ResponseEntity<ResponseDto> telAuth(TelAuthRequestDto dto) {

        String telNumber = dto.getTelNumber();

        try {

            boolean isExistedTelNumber = nurseRepository.existsByTelNumber(telNumber);
            if (isExistedTelNumber) return ResponseDto.duplicatedTelNumber();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        String authNumber = AuthNumberCreator.number4();

        try {

            TelAuthNumberEntity telAuthNumberEntity = new TelAuthNumberEntity(telNumber, authNumber);
            telAuthNumberRepository.save(telAuthNumberEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }

}
