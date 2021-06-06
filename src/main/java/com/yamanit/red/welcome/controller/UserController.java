package com.yamanit.red.welcome.controller;

import com.yamanit.red.common.controller.protocol.CommonProtocol;
import com.yamanit.red.user.model.User;
import com.yamanit.red.user.service.UserService;
import com.yamanit.red.welcome.controller.protocol.GetUserProtocol;
import com.yamanit.red.welcome.controller.protocol.PostUserUpdateProtocol;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping("/users/{uuid}")
	@ApiOperation(value = "사용자 정보 조회")
	public GetUserProtocol.Response getUser(@PathVariable String uuid) {
		User user = userService.getUser(uuid);

		return CommonProtocol.getResponse(GetUserProtocol.Response.class)
							 .setUser(user);
	}

	@PostMapping("/users/{uuid}/update")
	@ApiOperation(value = "사용자 정보 변경")
	public PostUserUpdateProtocol.Response getUser(@PathVariable String uuid, @RequestBody PostUserUpdateProtocol.Request request) {
		User modifiedUser = userService.modifyUser(new User(uuid).setNickname(request.getNickname()));

		return CommonProtocol.getResponse(PostUserUpdateProtocol.Response.class)
							 .setUser(modifiedUser);
	}
}
