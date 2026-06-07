package com.bookat.readings_manager.enums;

import com.bookat.readings_manager.repository.UserRepository;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role){
        this.role=role;
    }

    public String getRole(){
        return role;
    }
}
