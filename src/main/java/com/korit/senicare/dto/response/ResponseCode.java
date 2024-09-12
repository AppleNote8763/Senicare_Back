package com.korit.senicare.dto.response;

// ResponseDTO의 code 값 상수

public interface ResponseCode {

    String SUCCESS = "SU";

    String VALIDATION_FAIL = "VF";
    String DUPLICATED_USER_ID = "DI";
    String DUPLICATED_TEL_NUMBER = "DT";

    String TEL_AUTH_FAIL = "TAF";
    String SIGN_IN_FAIL = "SF";

    String MESSAGE_SEND_FAIL = "MSF";
    String TOKEN_CREATE_FAIL = "TCF";
    String DATABASE_ERROR = "DBE";

}
