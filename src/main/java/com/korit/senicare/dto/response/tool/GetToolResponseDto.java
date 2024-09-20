package com.korit.senicare.dto.response.tool;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.response.ResponseCode;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.ResponseMessage;
import com.korit.senicare.entity.ToolEntity;

import lombok.Getter;

@Getter
public class GetToolResponseDto extends ResponseDto {

    private Integer toolNumber;
    private String name;
    private String purpose;
    private Integer count;

    private GetToolResponseDto(ToolEntity toolEntity) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.toolNumber = toolEntity.getToolNumber();
        this.name = toolEntity.getName();
        this.purpose = toolEntity.getPurpose();
        this.count = toolEntity.getCount();
    }

    public static ResponseEntity<GetToolResponseDto> success(ToolEntity toolEntity) {
        GetToolResponseDto responseBody = new GetToolResponseDto(toolEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
