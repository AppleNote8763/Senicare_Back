package com.korit.senicare.dto.response.nurse;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.senicare.common.object.ChargedCustomer;
import com.korit.senicare.dto.response.ResponseCode;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.ResponseMessage;
import com.korit.senicare.entity.CustomerEntity;

import lombok.Getter;

@Getter
public class GetChargedCustomerResponseDto extends ResponseDto {

    private List<ChargedCustomer> customers;

    private GetChargedCustomerResponseDto(List<CustomerEntity> customerEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.customers = ChargedCustomer.getList(customerEntities);
    }

    public static ResponseEntity<GetChargedCustomerResponseDto> success(List<CustomerEntity> customerEntities) {
        GetChargedCustomerResponseDto responseBody = new GetChargedCustomerResponseDto(customerEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
