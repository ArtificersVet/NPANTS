package com.nPants.nPants.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {
    @Bean
    public UserDetailsManager customUsers(DataSource dataSource){
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery("select email, password, 1 as status from usuario where email = ?");
        users.setAuthoritiesByUsernameQuery("select u.email, r.nombre from usuario u" + 
               " inner join rol r on r.id = u.rol_id "+
               " where u.email = ?");

        return users;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new CustomPasswordEncoder(); // Usando tu CustomPasswordEncoder
    }
}
