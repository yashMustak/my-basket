package com.wayfair.userService.service;

import com.wayfair.userService.entity.UsersDetails;
import com.wayfair.userService.entity.UsersRole;
import com.wayfair.userService.repository.UserRepository;
import com.wayfair.userService.entity.Users;
import com.wayfair.userService.repository.UsersRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersRoleRepository usersRoleRepository;


    @Autowired
    UserRepository personRepository;


    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Users getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Users saveUser(Users users) {
        users.setActive(1);
        UsersRole role = usersRoleRepository.findUserRoleByRoleName("ROLE_USER");
        users.setRole(role);
        return userRepository.save(users);
    }

}
