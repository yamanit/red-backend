package com.yamanit.red.common.controller.protocol;

import com.yamanit.red.common.RedApiException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

public class CommonProtocol {
	public static <T extends Response> T getResponse(Class<T> clazz) {
		try {
			T response = clazz.newInstance();

			response.setHeader(ResponseHeaders.SUCCESS);

			return response;
		} catch (Exception ex) {
			throw new RedApiException(ResponseHeaders.RESPONSE_INSTANCE_CREATE_FAIL);
		}
	}

	@Data
	@Accessors(chain = true)
	public static class Response {
		private ResponseHeader header;
	}

	@RequiredArgsConstructor
	@ApiModel("CommonProtocol@ResponseHeader")
	@Data
	public static class ResponseHeader {
		@ApiModelProperty("결과코드")
		private final int resultCode;

		@ApiModelProperty("결과메시지")
		private final String resultMessage;
	}

	public static class ResponseHeaders {
		public static final ResponseHeader SUCCESS = new ResponseHeader(0, "Success");
		public static final ResponseHeader RESPONSE_INSTANCE_CREATE_FAIL = new ResponseHeader(1, "Creating response instance is failed.");
		public static final ResponseHeader UNKNOWN_FAIL = new ResponseHeader(2, "The requested operation failed for an unknown reason.");
	}
}
