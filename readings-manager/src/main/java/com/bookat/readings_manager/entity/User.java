package com.bookat.readings_manager.entity;

import com.bookat.readings_manager.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Data
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id")
    private UUID userId;

    private String username;
    private String name;
    private String email;
    private String password;
    private UserRole role;
}
