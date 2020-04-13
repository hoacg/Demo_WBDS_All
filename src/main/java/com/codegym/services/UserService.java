package com.codegym.services;

import com.codegym.models.User;
import com.codegym.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myDBUser = userRepository.findByEmail(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(myDBUser.getRole().getAuthority()));

        org.springframework.security.core.userdetails.User
                userDetails = new org.springframework.security.core.userdetails.User(
                        myDBUser.getEmail(),
                        myDBUser.getPassword(),
                        authorities
                );

        return userDetails;
    }
}
