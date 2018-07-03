package de.fbeutel.todolistsbackend.user.domain;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

  @Id
  private final String username;
  private final String password;
}
