package com.user.common;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.user.contant.UserServiceErrorCodes;
import com.user.dto.BaseResponse;
import com.user.exception.UserException;

import lombok.extern.slf4j.Slf4j;

/**
 * This class handles the application level exception, if left unhandled.
 * 
 * @ExceptionHandler and provide it with a exception type that we want to
 *                   handle.
 */
@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler {

	private static final String ERROR_RESPONSE_LOG_MESSAGE = "Response | status: {} | code: {} | message: {}";

	@ExceptionHandler(UserException.class)
	public ResponseEntity<BaseResponse> handleGameReportingException(UserException ex) {
		log.error("UserException ", ex);
		return createResponseEntity(ex);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<BaseResponse> handleException(Exception ex) {
		log.error("Exception ", ex);
		return createResponseEntity(new UserException(
				Optional.of(UserServiceErrorCodes.INTERNAL_SERVER_ERROR.getHttpCode()),
				UserServiceErrorCodes.NO_CONTENT.getErrorCode(), UserServiceErrorCodes.NO_CONTENT.getErrorMessage()));
	}

	private ResponseEntity<BaseResponse> createResponseEntity(UserException ex) {
		Integer httpCode = ex.getHttpCode().orElse(HttpStatus.INTERNAL_SERVER_ERROR.value());
		log.error(ERROR_RESPONSE_LOG_MESSAGE, httpCode, ex.getErrorCode(), ex.getMessage());
		return ResponseEntity.status(httpCode).body(new BaseResponse(ex.getErrorCode(), ex.getMessage()));
	}

}
