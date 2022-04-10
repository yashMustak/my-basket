package com.wayfair.userService.controller;

import com.wayfair.userService.entity.Users;
import com.wayfair.userService.http.header.HeaderGenerator;
import com.wayfair.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @Autowired
    private HeaderGenerator headerGenerator;

    // comment
    @PostMapping(value = "/registration")
    public ResponseEntity<Users> addUser(@RequestBody Users users, HttpServletRequest request){
        if(users != null)
            try {
                userService.saveUser(users);
                return new ResponseEntity<Users>(
                        users,
                        headerGenerator.getHeadersForSuccessPostMethod(request, users.getId()),
                        HttpStatus.CREATED);
            }catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Users>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        return new ResponseEntity<Users>(HttpStatus.BAD_REQUEST);
    }
}
