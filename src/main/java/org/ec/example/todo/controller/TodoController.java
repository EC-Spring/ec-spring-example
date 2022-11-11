package org.ec.example.todo.controller;

import org.ec.example.todo.entity.Todo;
import org.ec.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/:id")
    public ResponseEntity<Todo> read(@PathVariable Long id) {
        return new ResponseEntity<>(todoService.findTodo(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Todo>> readAll() {
        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.create(todo), HttpStatus.CREATED);
    }

    @PutMapping("/:id")
    public ResponseEntity<Todo> update(@RequestBody Todo todo, @PathVariable Long id) {
        return new ResponseEntity<>(todoService.update(todo, id), HttpStatus.OK);
    }

    @DeleteMapping("/:id")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
