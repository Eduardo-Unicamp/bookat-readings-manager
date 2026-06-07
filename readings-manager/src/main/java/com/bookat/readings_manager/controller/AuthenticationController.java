package com.bookat.readings_manager.controller;

import com.bookat.readings_manager.dto.AuthenticationDTO;
import com.bookat.readings_manager.dto.AuthenticationResponseDTO;
import com.bookat.readings_manager.dto.RegisterDTO;
import com.bookat.readings_manager.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;//do outro tutorial


    @PostMapping("/login")
    public ResponseEntity<Object> authenticate(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        AuthenticationResponseDTO token = authenticationService.authenticate(authenticationDTO);//call my authentication service
        return ResponseEntity.ok().body(token);


    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterDTO registerDTO){
        return authenticationService.register(registerDTO);
    }


}
