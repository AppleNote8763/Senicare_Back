package com.korit.senicare.dto.response;

// ResponseDto의 message 상수

public interface ResponseMessage {

    String SUCCESS = "Success.";

    String VALIDATION_FAIL = "Validation failed.";
    String DUPLICATED_USER_ID = "Duplicated user id.";
    String DUPLICATED_TEL_NUMBER = "Duplicated user tel number.";

    String TEL_AUTH_FAIL = "Tel number authentication failed.";
    String SIGN_IN_FAIL = "Sign in failed.";

    String MESSAGE_SEND_FAIL = "Auth number send failed.";
    String DATABASE_ERROR = "Database error.";

}
