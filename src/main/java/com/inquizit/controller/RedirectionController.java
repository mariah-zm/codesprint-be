package com.inquizit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class RedirectionController {

    @Value("${client.url}")
    private String clientUrl;

    @GetMapping("/")
    public void handleOAuthRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect(clientUrl);
    }

}
