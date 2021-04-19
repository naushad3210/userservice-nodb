package com.user.contant;

import static com.user.contant.Constants.ERR_MSG_NO_CONTENT;
import static com.user.contant.Constants.ERR_MSG_TECHNICAL_ERROR;

import lombok.Getter;

@Getter
public enum UserServiceErrorCodes {

    NO_CONTENT(204, 1204, ERR_MSG_NO_CONTENT), 
    INTERNAL_SERVER_ERROR(500, 1500, ERR_MSG_TECHNICAL_ERROR);
    
    private final int httpCode;
    private final int errorCode;
    private final String errorMessage;

    private UserServiceErrorCodes(int httpCode, int errorCode, String errorMessage) {
        this.httpCode = httpCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
