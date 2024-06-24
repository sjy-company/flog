package com.flog.common.config;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.flog.domain.user.entity.User;
import com.flog.domain.user.service.UserService;
import com.flog.security.PrincipalDetail;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AuditorAwareConfig implements AuditorAware<User> {
	private final UserService userService;

    @Override
    @NonNull
    public Optional<User> getCurrentAuditor() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof PrincipalDetail principalDetail) {
			String username = principalDetail.getUsername();
            User user = userService.findByUsername(username);

            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}
