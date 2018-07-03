package de.fbeutel.todolistsbackend.configuration;

import org.springframework.stereotype.Component;

import de.fbeutel.todolistsbackend.user.domain.User;
import de.fbeutel.todolistsbackend.user.domain.UserRepository;

@Component
public class UserDataInitialization {

  private final UserRepository userRepository;

  public UserDataInitialization(final UserRepository userRepository) {
    this.userRepository = userRepository;
    initUserData();
  }

  private void initUserData() {
    final User adminUser = User.builder().username("admin@gmail.com").password("123456").build();

    userRepository.save(adminUser);
  }
}
