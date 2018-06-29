package de.fbeutel.todolistsbackend.todo.domain;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, String> {
}
