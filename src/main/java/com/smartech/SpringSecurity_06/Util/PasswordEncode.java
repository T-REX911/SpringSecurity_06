package com.smartech.SpringSecurity_06.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncode {
    public String encodePassord(String password){
        BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
        String encodedPWD = bpe.encode(password);
        return encodedPWD;
    }
}
