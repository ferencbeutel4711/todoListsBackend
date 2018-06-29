package de.fbeutel.todolistsbackend.health.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public class HealthRestController {

    public ResponseEntity getHealth() {
        return ResponseEntity.ok().build();
    }
}
