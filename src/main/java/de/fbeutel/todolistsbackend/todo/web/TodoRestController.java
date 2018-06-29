package de.fbeutel.todolistsbackend.todo.web;

import de.fbeutel.todolistsbackend.exception.NotFoundException;
import de.fbeutel.todolistsbackend.todo.domain.Todo;
import de.fbeutel.todolistsbackend.todo.domain.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/todos")
public class TodoRestController {

    private final TodoRepository todoRepository;

    public TodoRestController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<String> getTodo(@PathVariable final String todoId) {
        return ResponseEntity.ok()
                .body(todoRepository.findById(todoId).orElseThrow(NotFoundException::new).getSerializedTodo());
    }

    @PutMapping("/{todoId}")
    public ResponseEntity updateTodo(@PathVariable final String todoId, @RequestBody final String todo) {
        final String updatedId = todoRepository.save(Todo.builder()
                .id(todoId)
                .serializedTodo(todo)
                .build()).getId();
        return ResponseEntity.created(URI.create("http://127.0.0.1:9999/todos/" + updatedId)).build();
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable final String todoId) {
        todoRepository.deleteById(todoId);

        return ResponseEntity.noContent().build();
    }
}
