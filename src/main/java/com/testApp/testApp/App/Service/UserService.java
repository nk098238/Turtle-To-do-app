package com.testApp.testApp.App.Service;

import com.testApp.testApp.App.Entity.User;
import com.testApp.testApp.App.Repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String ValidateUser(User user){
        Optional<User> ValidUser = userRepository.findByUsername(user.getUsername());

        if(ValidUser.isPresent()){
            if(Objects.equals(ValidUser.get().getPassword(), user.getPassword())){
                return "Valid user";
            }
        }
        return "Invalid User";
    }

    public String getSessionInfo(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    };

}
