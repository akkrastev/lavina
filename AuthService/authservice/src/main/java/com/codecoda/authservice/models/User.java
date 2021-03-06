package com.codecoda.authservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Username")
    @NotBlank(message = "Username is a required field")
    private String username;

    @Column(name = "Password")
    @NotBlank(message = "Password is a required field")
    @JsonIgnore
    @JsonProperty(value = "password")
    private String password;

    @Column(name = "Email")
    @NotBlank(message = "Email is a required field")
    private String email;

    @Column(name = "Createdat")
    private LocalDateTime createdat;

    @Column(name = "Updatedat")
    private LocalDateTime updatedat;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            schema = "letsplay",
            name = "USERROLES",
            joinColumns = @JoinColumn(name = "Userid"),
            inverseJoinColumns = @JoinColumn(name = "Roleid")
    )
    private List<Role> roles;

    public User() {

    }

    public User(int id, String username, String password, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdat = createdAt;
        this.updatedat = updatedAt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    @JsonProperty(value = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdat;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdat = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedat;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedat = updatedAt;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdat +
                ", updatedAt=" + updatedat +
                '}';
    }
}
