package de.fbeutel.todolistsbackend.todo.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import lombok.SneakyThrows;

import de.fbeutel.todolistsbackend.todo.domain.Todo;
import de.fbeutel.todolistsbackend.todo.domain.TodoRepository;

@Controller
@RequestMapping("/todos")
public class TodoHtmlController {

  private final TodoRepository todoRepository;

  public TodoHtmlController(final TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @SneakyThrows
  @GetMapping("/list")
  public ModelAndView getAll() {
    final Map<String, Object> model = new ConcurrentHashMap<>();

    final ArrayList<Object> todos = new ArrayList<>();
    todoRepository.findAll().forEach(todo -> todos.add(parseTodo(todo)));
    model.put("todos", todos);

    return new ModelAndView("todoList", model);
  }

  @SneakyThrows
  private HashMap<String, Object> parseTodo(final Todo todo) {
    return new ObjectMapper().readValue(todo.getSerializedTodo(),
      TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, Object.class));
  }
}
