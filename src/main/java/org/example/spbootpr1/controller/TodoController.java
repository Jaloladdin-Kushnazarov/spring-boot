package org.example.spbootpr1.controller;

import lombok.RequiredArgsConstructor;
import org.example.spbootpr1.entity.Todo;
import org.example.spbootpr1.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {


    private final TodoRepository todoRepository;

    @GetMapping
    public List<Todo> getAll(){
        return todoRepository.findAll();
    }


    @PostMapping
    public void save(@RequestBody Todo todo){
        todoRepository.save(todo);
    }



    @PutMapping
    public void updateTodo(@RequestBody Todo todo){
        todoRepository.save(todo);
    }



    @DeleteMapping
    public void deleteAll(){
        todoRepository.deleteAll();    
    }


}
