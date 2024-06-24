package com.flog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flog.common.response.ApiResponse;
import com.flog.domain.user.entity.User;
import com.flog.domain.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class IndexController {
	private final UserService userService;

	@GetMapping("/")
	public ApiResponse<String> index() {
		return ApiResponse.isSuccess("test");
	}

	@GetMapping("/save")
	public ApiResponse<User> save() {
		User user = userService.saveNew();
		return ApiResponse.isSuccess(user);
	}
}
