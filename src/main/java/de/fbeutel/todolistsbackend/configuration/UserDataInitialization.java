package de.fbeutel.todolistsbackend.configuration;

import de.fbeutel.todolistsbackend.user.domain.User;
import de.fbeutel.todolistsbackend.user.domain.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserDataInitialization {

    private final UserRepository userRepository;

    public UserDataInitialization(UserRepository userRepository) {
        this.userRepository = userRepository;
        initUserData();
    }

    private void initUserData() {
        final User adminUser = User.builder()
                .username("admin@gmail.com")
                .password("admin")
                .build();

        userRepository.save(adminUser);
    }
}
