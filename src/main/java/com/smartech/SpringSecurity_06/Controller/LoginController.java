package com.smartech.SpringSecurity_06.Controller;

import com.smartech.SpringSecurity_06.DTO.AuthRequest;
import com.smartech.SpringSecurity_06.DTO.AuthResponse;
import com.smartech.SpringSecurity_06.Util.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signing")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String token = jwtService.generateToken(request.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> adminLogin(){
        return ResponseEntity.ok("Welcome Admin");
    }
}
