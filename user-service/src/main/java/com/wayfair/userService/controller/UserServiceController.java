package com.wayfair.userService.controller;

import com.wayfair.userService.entity.Users;
import com.wayfair.userService.http.header.HeaderGenerator;
import com.wayfair.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserServiceController {

        @Autowired
        UserService userService;

        @Autowired
        private HeaderGenerator headerGenerator;


        @GetMapping(value = "/users")
        public ResponseEntity<List<Users>> getAllUsers(){
                List<Users> users =  userService.getAllUsers();
                if(!users.isEmpty()) {
                        return new ResponseEntity<List<Users>>(
                                users,
                                headerGenerator.getHeadersForSuccessGetMethod(),
                                HttpStatus.OK);
                }
                return new ResponseEntity<List<Users>>(
                        headerGenerator.getHeadersForError(),
                        HttpStatus.NOT_FOUND);
        }

        @GetMapping (value = "/users", params = "name")
        public ResponseEntity<Users> getUserByName(@RequestParam("name") String userName){
                Users user = userService.getUserByName(userName);
                if(user != null) {
                        return new ResponseEntity<Users>(
                                user,
                                headerGenerator.
                                        getHeadersForSuccessGetMethod(),
                                HttpStatus.OK);
                }
                return new ResponseEntity<Users>(
                        headerGenerator.getHeadersForError(),
                        HttpStatus.NOT_FOUND);
        }

        @GetMapping (value = "/users/{id}")
        public ResponseEntity<Users> getUserById(@PathVariable("id") Long id){
                Users user = userService.getUserById(id);
                if(user != null) {
                        return new ResponseEntity<Users>(
                                user,
                                headerGenerator.
                                        getHeadersForSuccessGetMethod(),
                                HttpStatus.OK);
                }
                return new ResponseEntity<Users>(
                        headerGenerator.getHeadersForError(),
                        HttpStatus.NOT_FOUND);
        }

        @PostMapping (value = "/users")
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
