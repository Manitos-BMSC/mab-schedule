package bo.edu.ucb.mabschedule.mabschedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class GlobalSecurityConfiguration {

    private final KeycloakJwtTokenConverter keycloakJwtTokenConverter;

    public GlobalSecurityConfiguration(TokenConverterProperties properties) {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter
                = new JwtGrantedAuthoritiesConverter();
        this.keycloakJwtTokenConverter
                = new KeycloakJwtTokenConverter(
                jwtGrantedAuthoritiesConverter,
                properties);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( (authorizeHttpRequests) -> {
            authorizeHttpRequests
                    .requestMatchers("/api/v1/appointment/**").hasRole("doctor")
                    .requestMatchers("/api/v1/period/periods").hasAnyRole("doctorJefe", "doctor", "paciente")
                    .requestMatchers( HttpMethod.GET ,"api/v1/scheduleDoctor/**").hasAnyRole("doctorJefe", "doctor", "paciente")
                    .requestMatchers( HttpMethod.GET ,"api/v1/scheduleDoctor/doctor/**").hasAnyRole("doctorJefe", "doctor", "paciente")
                    .requestMatchers( HttpMethod.POST ,"api/v1/scheduleDoctor/**").hasAnyRole("doctorJefe", "doctor")
                    .anyRequest()
                    .denyAll();
        });
        http.oauth2ResourceServer( (oauth2) -> {
            oauth2.jwt( (jwt) -> jwt.jwtAuthenticationConverter(keycloakJwtTokenConverter));
        });
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}