package com.flog.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors(AbstractHttpConfigurer::disable);
		http.csrf(AbstractHttpConfigurer::disable);

		http.formLogin(AbstractHttpConfigurer::disable);

		http.authorizeHttpRequests(request ->
			request
				.requestMatchers(PathRequest.toH2Console()).permitAll() // H2 Console 허용
				.anyRequest().permitAll()
		);

		http.headers(headers -> headers.frameOptions(FrameOptionsConfig::sameOrigin)); // H2 Console 사용을 위해

		return http.build();
	}
}
