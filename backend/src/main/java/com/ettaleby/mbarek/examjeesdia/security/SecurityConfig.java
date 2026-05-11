package com.ettaleby.mbarek.examjeesdia.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(withDefaults())
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()

                .requestMatchers(HttpMethod.GET, "/api/agences/**").hasAnyRole("CLIENT", "EMPLOYE", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/agences/**").hasAnyRole("EMPLOYE", "ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/agences/**").hasAnyRole("EMPLOYE", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/agences/**").hasRole("ADMIN")

                .requestMatchers(HttpMethod.GET, "/api/vehicules/**").hasAnyRole("CLIENT", "EMPLOYE", "ADMIN")
                .requestMatchers(HttpMethod.PATCH, "/api/vehicules/**").hasAnyRole("EMPLOYE", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/vehicules/**").hasRole("ADMIN")

                .requestMatchers(HttpMethod.POST, "/api/voitures/**", "/api/motos/**").hasAnyRole("EMPLOYE", "ADMIN")

                .requestMatchers(HttpMethod.GET, "/api/locations/**").hasAnyRole("CLIENT", "EMPLOYE", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/locations/**").hasAnyRole("CLIENT", "EMPLOYE", "ADMIN")
                .requestMatchers(HttpMethod.PATCH, "/api/locations/**").hasAnyRole("EMPLOYE", "ADMIN")

                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}