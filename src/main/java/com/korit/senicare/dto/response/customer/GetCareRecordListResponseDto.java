package com.korit.senicare.dto.response.customer;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.senicare.common.object.CareRecord;
import com.korit.senicare.dto.response.ResponseCode;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.ResponseMessage;
import com.korit.senicare.entity.CareRecordEntity;

import lombok.Getter;

@Getter
public class GetCareRecordListResponseDto extends ResponseDto {

    private List<CareRecord> careRecords;

    private GetCareRecordListResponseDto(List<CareRecordEntity> careRecordEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.careRecords = CareRecord.getList(careRecordEntities);
    }

    public static ResponseEntity<GetCareRecordListResponseDto> success(List<CareRecordEntity> careRecordEntities) {
        GetCareRecordListResponseDto responseBody = new GetCareRecordListResponseDto(careRecordEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
