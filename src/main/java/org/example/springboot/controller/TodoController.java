package org.example.springboot.controller;

import jakarta.validation.Valid;
import org.example.springboot.entity.Todo;
import org.example.springboot.exeptions.ItemNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;




@RestController
@RequestMapping("/todos")
public class TodoController {
    private final AtomicInteger count = new AtomicInteger(1);
    private final List<Todo> todos = new ArrayList<>(List.of(
            new Todo(count.getAndIncrement(), "Todo 1", "High"),
            new Todo(count.getAndIncrement(), "Todo 2", "Medium"),
            new Todo(count.getAndIncrement(), "Todo 3", "Low")
    ));

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok(todos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Todo> get(@PathVariable Integer id) {
        return ResponseEntity.ok(todos.stream().filter(t -> t.getId().equals(id)).findFirst()
                .orElseThrow(() -> new ItemNotFoundExeption("Todo not found with id: " + id)));
    }



    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody @Valid Todo todo) {
        todo.setId(count.getAndIncrement());
        todos.add(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);

    }
}