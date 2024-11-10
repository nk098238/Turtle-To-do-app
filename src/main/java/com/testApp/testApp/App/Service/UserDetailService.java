package com.testApp.testApp.App.Service;

import com.testApp.testApp.App.Entity.User;
import com.testApp.testApp.App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = repo.findByUsername(username);

        if(Objects.isNull(user)){
            throw  new UsernameNotFoundException("User not found");
        }
            return new UserPrincipal(user);


    }
}
