package com.inquizit.controller;

import com.inquizit.exceptions.UserIsNotAuthenticatedException;
import com.inquizit.model.enums.RoleType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Value("${auth.google.redirect}")
    private String googleSignInRedirect;

    @Value("${auth.facebook.redirect}")
    private String facebookSignInRedirect;

    @GetMapping("/is-authenticated")
    public @ResponseBody boolean handleIsUserAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAuthenticated = !(authentication instanceof AnonymousAuthenticationToken);
        log.info("Is user authenticated: {}", isAuthenticated);

        return isAuthenticated;
    }

    @GetMapping("/login-google")
    public void handleGoogleLogin(HttpServletResponse response) throws IOException {
        // Redirecting user to google sign up page
        log.info("User is authenticating with google");
        response.sendRedirect(googleSignInRedirect);
    }

    /**
     * Retrieving user role type
     * @return role type mapped to integer value
     */
    @GetMapping("/role")
    public @ResponseBody int getUserRole() {
        return RoleType.TEACHER.getValue();
    }

    @GetMapping("/login-facebook")
    public void handleFacebookLogin(HttpServletResponse response) throws IOException {
        // Redirecting user to google sign up page
        log.info("User is authenticating with facebook");
        response.sendRedirect(facebookSignInRedirect);
    }

    @PostMapping("/logout")
    public void handleLogout(HttpServletRequest request, HttpServletResponse response) {
        Cookie rememberMeCookie = new Cookie("JSESSIONID", "");
        rememberMeCookie.setMaxAge(0);
        response.addCookie(rememberMeCookie);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }

}
