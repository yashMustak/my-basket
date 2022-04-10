package com.wayfair.userService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="user_name", nullable = false, unique = true,length = 50)
    private String userName;

    @Column(name="user_password", nullable = false, length = 50)
    private String userPassword;

    @Column(name="active")
    private int active;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="user_details_id")
    private UsersDetails usersDetails;

    @ManyToOne
    @JoinColumn (name = "role_id")
    private UsersRole role;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public UsersDetails getUsersDetails() {
        return usersDetails;
    }

    public void setUserDetails(UsersDetails usersDetails) {
        this.usersDetails = usersDetails;
    }

    public UsersRole getRole() {
        return role;
    }

    public void setRole(UsersRole role) {
        this.role = role;
    }
}
