package dev.thechibbis.market;

import dev.thechibbis.market.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class OAuth2LoginSecurityConfig {
    private final UserService userService;

    public OAuth2LoginSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .oauth2Login(oAuth2LoginConfigurer -> {
                    oAuth2LoginConfigurer.successHandler((request, response, authentication) -> {
                        OAuth2AuthenticationToken authenticationToken = (OAuth2AuthenticationToken) authentication;
                        OAuth2User oauth2User = authenticationToken.getPrincipal();

                        System.out.println(oauth2User);

                        userService.registerUser(oauth2User);  // Register or update the user
                        response.sendRedirect("/home");
                    });
                });
        return http.build();
    }
}
