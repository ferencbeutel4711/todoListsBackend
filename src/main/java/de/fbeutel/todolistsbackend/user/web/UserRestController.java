package de.fbeutel.todolistsbackend.user.web;

import de.fbeutel.todolistsbackend.exception.NotAuthorizedException;
import de.fbeutel.todolistsbackend.todo.domain.Todo;
import de.fbeutel.todolistsbackend.todo.domain.TodoRepository;
import de.fbeutel.todolistsbackend.user.domain.User;
import de.fbeutel.todolistsbackend.user.domain.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody final User userToLogin) {
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
