package fsb.ucar.kidcaremanager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .headers(h -> h.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)) // Permet l'utilisation de frames (e.g., pour H2 console)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // Autorise l'accès à H2 Console
                        .anyRequest().authenticated() // Nécessite une authentification pour toute autre requête
                )
                .formLogin(f-> f.defaultSuccessUrl("/swagger-ui/index.html", true))
                .logout(l -> l
                        .logoutUrl("/logout") // URL pour se déconnecter
                        .logoutSuccessUrl("/login?logout") // Redirection après déconnexion
                        .permitAll() // Permet la déconnexion sans authentification
                )
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Crée un utilisateur en mémoire avec le rôle USER
        UserDetails user = User.builder()
                .username("staticUser") // Nom d'utilisateur
                .password(passwordEncoder.encode("password")) // Mot de passe
                .roles("USER") // Rôle assigné
                .build();
        return new InMemoryUserDetailsManager(user);
    }


    public PasswordEncoder passwordEncoder() {
        // Utilise BCrypt pour encoder les mots de passe
        return new BCryptPasswordEncoder();
    }
}
