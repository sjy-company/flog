package com.flog.domain.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.flog.common.error.exception.CustomException;
import com.flog.domain.user.entity.User;
import com.flog.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username)
			.orElseThrow(() -> new CustomException("ERROR_USER_NOT_FOUND"));
	}

	public User saveNew() {
		String encodedPassword = passwordEncoder.encode("passwd");

		User user = User.builder()
			.username("test")
			.password(encodedPassword)
			.build();
		userRepository.save(user);

		return user;
	}
}
