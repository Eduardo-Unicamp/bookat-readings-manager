package com.bookat.readings_manager.services;

import com.bookat.readings_manager.dto.AuthenticationDTO;
import com.bookat.readings_manager.dto.AuthenticationResponseDTO;
import com.bookat.readings_manager.dto.RegisterDTO;
import com.bookat.readings_manager.entity.User;
import com.bookat.readings_manager.infra.security.TokenService;
import com.bookat.readings_manager.infra.security.UserDetailsImpl;
import com.bookat.readings_manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserRepository userRepository;



    public AuthenticationResponseDTO authenticate(AuthenticationDTO authenticationDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                authenticationDTO.getUsername(),
                authenticationDTO.getPassword()
        );

        Authentication auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = tokenService.generateToken((UserDetailsImpl) auth.getPrincipal());
        return new AuthenticationResponseDTO(token);

    }
    public ResponseEntity<Object> register(RegisterDTO registerDTO){
        if(userRepository.findByUsername(registerDTO.getUsername()).isPresent()){
            return ResponseEntity.badRequest().body("Nome de usuário indisponível");
        }
        if(userRepository.findByEmail(registerDTO.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("O email informado já está em uso!");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.getPassword());

        User newUser = new User();
        newUser.setName(registerDTO.getName());
        newUser.setEmail(registerDTO.getEmail());
        newUser.setUsername(registerDTO.getUsername());
        newUser.setPassword(encryptedPassword);
        newUser.setRole(registerDTO.getRole());

        userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}