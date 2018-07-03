package de.fbeutel.todolistsbackend.todo.domain;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Todo {

  @Id
  private final String id;
  private final String serializedTodo;
}
