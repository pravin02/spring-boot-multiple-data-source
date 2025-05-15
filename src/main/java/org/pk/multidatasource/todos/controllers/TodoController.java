package org.pk.multidatasource.todos.controllers;

import org.pk.multidatasource.todos.entities.Todo;
import org.pk.multidatasource.todos.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public ResponseEntity<?> getUsersList() {
        return ResponseEntity.ok(this.todoRepository.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(Long userId) {
        return ResponseEntity.ok(this.todoRepository.findById(userId));
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody Todo todo) {
        return ResponseEntity.ok(this.todoRepository.save(todo));
    }

    @PostMapping("/save")
    public ResponseEntity<?> addMultipleUser(@RequestBody List<Todo> todos) {
        return ResponseEntity.ok(this.todoRepository.saveAll(todos));
    }

}
