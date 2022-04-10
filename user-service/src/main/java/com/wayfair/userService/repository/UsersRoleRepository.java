package com.wayfair.userService.repository;

import com.wayfair.userService.entity.UsersRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRoleRepository extends JpaRepository<UsersRole, Long> {
    UsersRole findUserRoleByRoleName(String roleName);
}
