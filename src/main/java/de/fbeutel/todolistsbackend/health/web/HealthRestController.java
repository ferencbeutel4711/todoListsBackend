package de.fbeutel.todolistsbackend.health.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public class HealthRestController {

  @GetMapping
  public ResponseEntity<Void> getHealth() {
    return ResponseEntity.ok().build();
  }
}
