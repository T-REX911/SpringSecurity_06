package com.smartech.SpringSecurity_06.Controller;

import com.smartech.SpringSecurity_06.DTO.AuthRequest;
import com.smartech.SpringSecurity_06.Model.User;
import com.smartech.SpringSecurity_06.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    @PreAuthorize("hasRole('ADMIN')")
    public String test(){
        return "This Is Admin Test";
    }

    @PostMapping("/getAll")
    //@PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/Create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createUser(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(userService.createUser(authRequest));
    }
}
