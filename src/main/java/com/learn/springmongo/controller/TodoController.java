package com.learn.springmongo.controller;

import com.learn.springmongo.model.TodoTask;
import com.learn.springmongo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo/")
@Slf4j
public class TodoController {
  @Autowired private TodoService todoService;

  @GetMapping("/{id}")
  public ResponseEntity<Object> getTaskById(@PathVariable String id) {
    TodoTask todoTask = todoService.getTaskById(id);
    return ResponseEntity.ok().body(todoTask);
  }

  @PostMapping("/addtask")
  public ResponseEntity<Object> addTaskToList(@RequestBody TodoTask todoTask) {
    return null;
  }
}
