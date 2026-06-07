package com.bookat.readings_manager.services;

import com.bookat.readings_manager.exception.UserNotFoundException;
import com.bookat.readings_manager.infra.security.UserDetailsImpl;
import com.bookat.readings_manager.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    //constructor
    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(UserDetailsImpl::new)
                .orElseThrow(UserNotFoundException::new);
    }
}
