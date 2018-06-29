package de.fbeutel.todolistsbackend.user.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class User {
    @Id
    private final String username;
    private final String password;
}
