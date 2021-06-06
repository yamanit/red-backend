package com.yamanit.red.welcome.controller;

import com.yamanit.red.common.controller.protocol.CommonProtocol;
import com.yamanit.red.user.service.UserService;
import com.yamanit.red.welcome.controller.protocol.PostHelloProtocol;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class WelcomeController {
	private final UserService userService;

	@PostMapping("/hello")
	@ApiOperation(value = "서버에 인사 전달", notes = "게임에 최초 접근 시 요청 하여 개인 식별 키를 획득 한다. 개인 식별 키는 쿠키로 구워 이후 요청에 자동 포함 되게 끔 하고 게임 진행 내내 사용 하게 된다.")
	public PostHelloProtocol.Response getUuid() {
		String uuid = userService.addUser().getUuid();

		return CommonProtocol.getResponse(PostHelloProtocol.Response.class)
							 .setUuid(uuid);
	}
}
