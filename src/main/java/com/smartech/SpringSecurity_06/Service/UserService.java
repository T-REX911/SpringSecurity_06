package com.smartech.SpringSecurity_06.Service;

import com.smartech.SpringSecurity_06.DTO.AuthRequest;
import com.smartech.SpringSecurity_06.Model.User;
import com.smartech.SpringSecurity_06.Repository.UserRepository;
import com.smartech.SpringSecurity_06.Util.PasswordEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncode encode;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String createUser(AuthRequest authRequest) {
        User newUser = new User();
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");

        newUser.setUsername(authRequest.getUsername());
        newUser.setPassword(encode.encodePassord(authRequest.getPassword()));
        newUser.setRoles(roles);

        User createdUser = userRepository.save(newUser);
        if(createdUser.getId() != null){
            return "The User Has Been Created";
        }else{
            return new Exception("Cannot create user").toString() ;
        }
    }
}
