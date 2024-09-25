package com.korit.senicare.dto.response;

// ResponseDTO의 code 값 상수

public interface ResponseCode {

    String SUCCESS = "SU";

    String VALIDATION_FAIL = "VF";
    String DUPLICATED_USER_ID = "DI";
    String DUPLICATED_TEL_NUMBER = "DT";
    String NO_EXIST_USER_ID = "NI";
    String NO_EXIST_TOOL = "NT";
    String NO_EXIST_CUSTOMER = "NC";
    String TOOL_INSUFFICIENT = "TI";

    String TEL_AUTH_FAIL = "TAF";
    String SIGN_IN_FAIL = "SF";
    String AUTHENTICATION_FAIL = "AF";

    String NO_PERMISSION = "NP";

    String MESSAGE_SEND_FAIL = "MSF";
    String TOKEN_CREATE_FAIL = "TCF";
    String DATABASE_ERROR = "DBE";

}
