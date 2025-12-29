import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // disable CSRF for simplicity; you can configure it properly later
            .authorizeHttpRequests()
                .requestMatchers("/auth/register", "/auth/login").permitAll()
                .anyRequest().authenticated()
            .and()
            .httpBasic(); // or JWT filter if you use JWT
        return http.build();
    }
}
