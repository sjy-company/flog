package com.flog.domain.user.service;

import org.springframework.stereotype.Service;

import com.flog.common.error.exception.CustomException;
import com.flog.domain.user.entity.User;
import com.flog.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username)
			.orElseThrow(() -> new CustomException("ERROR_USER_NOT_FOUND"));
	}
}
