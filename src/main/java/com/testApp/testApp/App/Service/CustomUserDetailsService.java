package com.testApp.testApp.App.Service;

import com.testApp.testApp.App.Entity.User;
//import com.testApp.testApp.App.Entity.UserPrincipal;
import com.testApp.testApp.App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService  {

    @Autowired
    private UserRepository userRepository; // Assume you have a UserRepository

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//      return null;
//    }

}
