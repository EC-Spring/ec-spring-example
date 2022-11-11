package org.ec.example.todo.service;

import org.ec.example.todo.entity.Todo;
import org.ec.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo findTodo(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id – must not be null."));
    }

    public Iterable<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo create(Todo todo) {
        todo.setCreatedAt(new Date().getTime());
        return todoRepository.save(todo);
    }

    public Todo update(Todo todo, Long id) {
        Todo updated = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id – must not be null."));
        updated.setUpdatedAt(new Date().getTime());

        if (todo.getContent() != null) {
            updated.setContent(todo.getContent());
        }

        return todoRepository.save(updated);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
