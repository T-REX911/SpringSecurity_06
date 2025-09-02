package com.smartech.SpringSecurity_06.DTO;

import lombok.Data;

@Data
public class AuthResponse {
    private String access_token;

    public AuthResponse() {
    }

    public AuthResponse(String token) {
        this.access_token = token;
    }

    public String getToken() {
        return access_token;
    }

    public void setToken(String token) {
        this.access_token = token;
    }
}
