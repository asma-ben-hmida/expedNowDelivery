package com.example.demo.ModelDTO;

import com.example.demo.ModelDomain.UserRole;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private String phoneNumber;
    private UserRole role;
    private boolean active;
}
