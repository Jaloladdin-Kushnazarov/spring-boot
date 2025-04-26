package org.example.spbootpr1.repository;

import org.example.spbootpr1.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Long> {

}
