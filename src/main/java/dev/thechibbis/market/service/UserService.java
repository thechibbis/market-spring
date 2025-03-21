package dev.thechibbis.market.service;

import dev.thechibbis.market.domain.model.Users;
import dev.thechibbis.market.domain.repository.UserRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(OAuth2User oAuth2User) {
        String name = (String) oAuth2User.getAttributes().get("name");
        String username = (String) oAuth2User.getAttributes().get("login");
        String email = (String) oAuth2User.getAttributes().get("email");

        Users user = userRepository.findByEmail(email);
        if (user == null) {
            user = new Users();
            user.setName(name);
            user.setUsername(username);
            user.setEmail(email);
            userRepository.save(user);
        }
    }
}
