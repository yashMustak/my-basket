package com.wayfair.userService.service;

import com.wayfair.userService.entity.Users;
import com.wayfair.userService.entity.UsersDetails;

import java.util.List;


public interface UserService {

    List<Users> getAllUsers();

    Users getUserById(Long id);

    Users getUserByName(String userName);

    Users saveUser(Users users);
}