package com.yamanit.red.common;

import com.yamanit.red.common.controller.protocol.CommonProtocol;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RedApiException extends RuntimeException {
	@Getter
	private final CommonProtocol.ResponseHeader responseHeader;
}
