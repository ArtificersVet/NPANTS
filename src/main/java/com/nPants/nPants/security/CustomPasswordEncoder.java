package com.nPants.nPants.security;

import com.nPants.nPants.services.UsuarioServicess.sha256;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        // Utiliza tu clase sha256 para encriptar la contraseña
        return sha256.hashPassword(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // Compara la contraseña ingresada en crudo con la contraseña almacenada
        return sha256.hashPassword(rawPassword.toString()).equals(encodedPassword);
    }

}
