package com.nPants.nPants.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {
    @Bean
    public UserDetailsManager customUsers(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery("select email, password, 1 as status from usuario where email = ?");
        users.setAuthoritiesByUsernameQuery("select u.email, r.nombre from usuario u" +
                " inner join rol r on r.id = u.rol_id " +
                " where u.email = ?");

        return users;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new CustomPasswordEncoder(); // Usando tu CustomPasswordEncoder
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/login").permitAll() // Permitir acceso sin autenticación a estas rutas
                .anyRequest().authenticated() // Proteger todas las demás rutas
            )
            .formLogin(form -> form
                .loginPage("/Login") // Ruta para el formulario de login personalizado
                .defaultSuccessUrl("/", true) // Redirigir a la raíz si el login es exitoso
                .failureHandler(new SimpleUrlAuthenticationFailureHandler("/Login?error"))
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );
        
        return http.build();
    }
}