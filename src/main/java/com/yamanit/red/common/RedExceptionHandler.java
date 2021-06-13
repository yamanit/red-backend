package com.yamanit.red.common;

import com.yamanit.red.common.controller.protocol.CommonProtocol;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RedExceptionHandler {
	@ExceptionHandler(RedApiException.class)
	public CommonProtocol.Response handleCommonException(RedApiException exception) {
		return new CommonProtocol.Response().setHeader(exception.getResponseHeader());
	}

	@ExceptionHandler(Throwable.class)
	public CommonProtocol.Response handleThrowable(Throwable throwable) {
		return new CommonProtocol.Response().setHeader(CommonProtocol.ResponseHeaders.UNKNOWN_FAIL);
	}
}
