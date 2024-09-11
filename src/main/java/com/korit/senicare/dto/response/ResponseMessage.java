package com.korit.senicare.dto.response;

// ResponseDto의 message 상수

public interface ResponseMessage {

    String SUCCESS = "Success.";

    String VALIDATION_FAIL = "Validation failed.";
    String DUPLICATED_USER_ID = "Duplicated user id.";

    String DATABASE_ERROR = "Database error.";

}
