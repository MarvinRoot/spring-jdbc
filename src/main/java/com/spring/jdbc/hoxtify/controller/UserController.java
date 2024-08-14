package com.spring.jdbc.hoxtify.controller;

import com.spring.jdbc.hoxtify.model.User;
import com.spring.jdbc.hoxtify.model.filter.UserFilter;
import com.spring.jdbc.hoxtify.service.AuthenticationService;
import com.spring.jdbc.hoxtify.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.spring.jdbc.hoxtify.model.constants.ConstantsEnum.ENTITY_MINUS_ONE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final AuthenticationService authService;
    public UserController(UserService userService, AuthenticationService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(
            @RequestHeader(value = "Authorization", required = false) String authorizationHeader,
            @RequestParam(value = "userid", defaultValue = ENTITY_MINUS_ONE + "") long userId
    ) {
        try {
            if (authorizationHeader == null || !authService.validateToken(authorizationHeader)) {
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }
            UserFilter filter = new UserFilter(userId);
            List<User> users = new ArrayList<>(userService.getUsers(filter));

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
