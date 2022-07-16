package com.inquizit.controller;

import com.inquizit.exceptions.UserIsNotAuthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandlerController {

    /**
     * Handler for unauthenticated errors
     * @param exception
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = UserIsNotAuthenticatedException.class)
    public @ResponseBody String handleNotAuthenticated(UserIsNotAuthenticatedException exception) {
        return "User is not authenticated";
    }
}
