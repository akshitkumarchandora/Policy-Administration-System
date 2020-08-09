package com.cognizant.pas.AuthorizationServer.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.pas.AuthorizationServer.model.UserDetailsImpl;
import com.cognizant.pas.AuthorizationServer.model.Users;
import com.cognizant.pas.AuthorizationServer.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByEmail(email);
        if(!user.isPresent()) {
            log.debug("{},Information: Throwing UsernameNotFoundException with message 'Invalid Credentials'",
                    this.getClass().getSimpleName());
            throw new UsernameNotFoundException("Invalid Username/password");
        }
//        user.stream().findFirst().map(i -> new UserDetailsImpl(i)).orElseThrow(() -> new UsernameNotFoundException("Invalid Username/password"));
        Users users = user.get();
        UserDetailsImpl userDetails = new UserDetailsImpl(users);
        log.info("{}, Information: Successfully Authenticated the user", this.getClass().getSimpleName());
        return userDetails;
    }
}
