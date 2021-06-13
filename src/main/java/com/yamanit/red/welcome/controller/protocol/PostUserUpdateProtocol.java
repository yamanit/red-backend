package com.yamanit.red.welcome.controller.protocol;

import com.yamanit.red.common.controller.protocol.CommonProtocol;
import com.yamanit.red.user.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class PostUserUpdateProtocol {
	@Getter
	@Setter
	@Accessors(chain = true)
	public static class Request {
		private String nickname;
	}

	@Getter
	@Setter
	@Accessors(chain = true)
	public static class Response extends CommonProtocol.Response {
		private User user;
	}
}
