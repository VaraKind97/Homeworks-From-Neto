package ru.netology.springboot_rest_task1.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.springboot_rest_task1.model.Authorities;
import ru.netology.springboot_rest_task1.exceptions.InvalidCredentials;
import ru.netology.springboot_rest_task1.exceptions.UnauthorizedUser;
import ru.netology.springboot_rest_task1.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    public String handleUnauthorizedUser(UnauthorizedUser ex) {
        return ex.getMessage();
    }
}
