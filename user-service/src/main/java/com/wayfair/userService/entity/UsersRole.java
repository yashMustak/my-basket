package com.wayfair.userService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wayfair.userService.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name ="users_role")
public class UsersRole {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name ="role_name")
    private String roleName;
    
    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<Users> users;

    public UsersRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

}
