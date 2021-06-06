package com.yamanit.red.welcome.controller.protocol;

import com.yamanit.red.common.controller.protocol.CommonProtocol;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

public class PostHelloProtocol {
	@EqualsAndHashCode(callSuper = true)
	@Data
	@Accessors(chain = true)
	@ApiModel("PostHelloProtocol@Response")
	public static class Response extends CommonProtocol.Response {
		@ApiModelProperty("개인 식별 키")
		private String uuid;
	}
}
