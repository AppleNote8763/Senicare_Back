package com.korit.senicare.dto.response;

// ResponseDTO의 code 값 상수

public interface ResponseCode {

    String SUCCESS = "SU";

    String VALIDATION_FAIL = "VF";
    String DUPLICATED_USER_ID = "DI";

    String DATABASE_ERROR = "DBE";

}
