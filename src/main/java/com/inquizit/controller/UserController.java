package com.inquizit.controller;

import com.inquizit.converter.DomainToOutput;
import com.inquizit.model.domain.User;
import com.inquizit.model.enums.RoleType;
import com.inquizit.model.output.UserOutput;
import com.inquizit.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserController {

    public final UserService userService;

    @Value("${client.url}")
    private String clientUrl;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * This endpoint is hit once login/register is successful. If a user does not exist on the database,
     * they are added and then redirected to the FE page where they are asked to choose a particular role.
     *
     * @param response contains client information
     * @param user     the OAuth2 user details upon successful login
     * @throws IOException if an error occurs on redirect
     */
    @GetMapping("/")
    public void handleOAuthRedirect(HttpServletResponse response, @AuthenticationPrincipal OAuth2User user) throws IOException {
        // Checking if user exists on DB
        String email = (String) user.getAttributes().get("email");
        if (userService.doesUserExist(email)){
            response.sendRedirect(clientUrl);
        } else {
            // If not register user and redirect to receive whether they are a student or teacher
            String name = (String) user.getAttributes().get("name");
            userService.addUser(email, name);
            response.sendRedirect(clientUrl + "/register/role");
        }
    }

    @GetMapping("/user")
    public @ResponseBody UserOutput getUserData(@AuthenticationPrincipal OAuth2User user) {
        String email = (String) user.getAttributes().get("email");
        User userObj = userService.getUserData(email);
        return DomainToOutput.convert(userObj);
    }

    @PostMapping("/user/{id}/role")
    public void updateUserRole(@PathVariable String id, @RequestParam int type) {
        RoleType roleType = RoleType.getRoleType(type);
        userService.updateUserRole(id, roleType);
    }

}
