package com.sirheadless.mybookmarks.authenticationfacade.impl;

import com.sirheadless.mybookmarks.authenticationfacade.AuthenticationFacade;
import com.sirheadless.mybookmarks.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationFacadeImpl implements AuthenticationFacade {

    @Autowired
    private UserService userService;

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public Integer getUserId() {
        String username = getAuthentication().getName();
        if (username == null) {
            return null;
        }

        return userService.getUserByUsername(username).getUserId();
    }


}
