package de.fbeutel.todolistsbackend.user.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.fbeutel.todolistsbackend.exception.NotAuthorizedException;
import de.fbeutel.todolistsbackend.user.domain.User;
import de.fbeutel.todolistsbackend.user.domain.UserRepository;

@RestController
@RequestMapping("/user")
public class UserRestController {

  private final UserRepository userRepository;

  public UserRestController(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping("/login")
  public ResponseEntity<Void> login(@RequestBody final User userToLogin) {
    if (userToLogin == null || userToLogin.getUsername() == null || userToLogin.getPassword() == null) {
      throw new NotAuthorizedException();
    }
    final User foundUser = userRepository.findById(userToLogin.getUsername()).orElseThrow(NotAuthorizedException::new);
    if (foundUser.getPassword().equals(userToLogin.getPassword())) {
      return ResponseEntity.ok().build();
    }

    throw new NotAuthorizedException();
  }
}
