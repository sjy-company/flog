package com.flog.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flog.domain.user.entity.User;
import com.flog.domain.user.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {

	private final UserRepository userRepository;

	public PrincipalDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
			.orElseThrow(() -> new BadCredentialsException("ERROR_USER_NOT_FOUND"));

		return new PrincipalDetail(
			user.getUsername(),
			user.getPassword()
		);
	}
}
