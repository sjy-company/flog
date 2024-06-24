package com.flog.common.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors(AbstractHttpConfigurer::disable);
		http.csrf(AbstractHttpConfigurer::disable);

		http.formLogin(AbstractHttpConfigurer::disable);
		// http.formLogin(AbstractHttpConfigurer ->
		// 	AbstractHttpConfigurer
		// 		.usernameParameter("username")
		// 		.passwordParameter("password")
		// 		.loginProcessingUrl("/login")
		// );

		http.authorizeHttpRequests(request ->
			request
				.requestMatchers(PathRequest.toH2Console()).permitAll() // H2 Console 허용
				// .requestMatchers("/save").permitAll()
				// .anyRequest().authenticated()
				.anyRequest().permitAll() // 모든 요청 허용
		);

		http.headers(headers -> headers.frameOptions(FrameOptionsConfig::sameOrigin)); // H2 Console 사용을 위해

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
