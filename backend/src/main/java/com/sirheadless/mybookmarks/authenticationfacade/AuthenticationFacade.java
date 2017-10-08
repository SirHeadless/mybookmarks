package com.sirheadless.mybookmarks.authenticationfacade;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
    Authentication getAuthentication();
    Integer getUserId();
}
