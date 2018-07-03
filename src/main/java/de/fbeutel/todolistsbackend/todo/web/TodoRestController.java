package de.fbeutel.todolistsbackend.todo.web;

import static java.util.stream.Collectors.toList;

import java.net.URI;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.fbeutel.todolistsbackend.exception.NotFoundException;
import de.fbeutel.todolistsbackend.todo.domain.Todo;
import de.fbeutel.todolistsbackend.todo.domain.TodoRepository;

@RestController
@RequestMapping("/todos")
public class TodoRestController {

  private final TodoRepository todoRepository;

  public TodoRestController(final TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @GetMapping
  public ResponseEntity<List<String>> getAll() {
    return ResponseEntity.ok()
      .body(StreamSupport.stream(todoRepository.findAll().spliterator(), false).map(Todo::getSerializedTodo).collect(toList()));
  }

  @GetMapping("/{todoId}")
  public ResponseEntity<String> getTodo(@PathVariable final String todoId) {
    return ResponseEntity.ok().body(todoRepository.findById(todoId).orElseThrow(NotFoundException::new).getSerializedTodo());
  }

  @PutMapping("/{todoId}")
  public ResponseEntity<String> updateTodo(@PathVariable final String todoId, @RequestBody final String todo) {
    final String updatedId = todoRepository.save(Todo.builder().id(todoId).serializedTodo(todo).build()).getId();
    return ResponseEntity.created(URI.create("http://127.0.0.1:9999/todos/" + updatedId)).build();
  }

  @DeleteMapping
  public ResponseEntity<Void> deleteAll() {
    todoRepository.deleteAll();

    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{todoId}")
  public ResponseEntity<Void> deleteTodo(@PathVariable final String todoId) {
    todoRepository.deleteById(todoId);

    return ResponseEntity.ok().build();
  }
}
