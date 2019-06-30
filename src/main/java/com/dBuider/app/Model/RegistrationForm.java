package com.dBuider.app.Model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm
{
    private String username;
    private String password;
    private String confirm;
    private String email;
    private String address;

    public User toUser(PasswordEncoder passwordEncoder)
    {
        return new User(username,passwordEncoder.encode(password),
                address, email);
    }
}
