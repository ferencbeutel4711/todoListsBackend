package de.fbeutel.todolistsbackend.todo.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder(toBuilder = true)
public class Todo {

    @Id
    private final String id;
    private final String serializedTodo;
}
