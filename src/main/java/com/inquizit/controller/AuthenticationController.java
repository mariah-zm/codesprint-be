package com.inquizit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
public class AuthenticationController {

    @Value("${client.url}")
    private String clientUrl;

    @Value("${auth.google.redirect}")
    private String googleSignInRedirect;

    @Value("${auth.facebook.redirect}")
    private String facebookSignInRedirect;

    @GetMapping("/auth/is-authenticated")
    public @ResponseBody boolean handleIsUserAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Is user authenticated: {}", !(authentication instanceof AnonymousAuthenticationToken));
        return !(authentication instanceof AnonymousAuthenticationToken);
    }

    @GetMapping("/auth/login-google")
    public void handleGoogleLogin(HttpServletResponse response) throws IOException {
        // Redirecting user to google sign up page
        log.info("User is authenticating with google");
        response.sendRedirect(googleSignInRedirect);
    }

    @GetMapping("/auth/login-facebook")
    public void handleFacebookLogin(HttpServletResponse response) throws IOException {
        // Redirecting user to google sign up page
        log.info("User is authenticating with facebook");
        response.sendRedirect(facebookSignInRedirect);
    }

    @PostMapping("/auth/logout")
    public void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie rememberMeCookie = new Cookie("JSESSIONID", "");
        rememberMeCookie.setMaxAge(0);
        response.addCookie(rememberMeCookie);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }

    @GetMapping("/")
    public void handleOAuthRedirect(HttpServletResponse response) throws IOException {
        // TODO handle user data to add in DB
        log.info("User has been authenticated");
        response.sendRedirect(clientUrl);
    }

}
