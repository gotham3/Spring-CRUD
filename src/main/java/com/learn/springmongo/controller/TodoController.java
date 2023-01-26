package com.learn.springmongo.controller;

import com.learn.springmongo.model.TodoTask;
import com.learn.springmongo.model.TodoTaskList;
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

  @GetMapping("/")
  public ResponseEntity<Object> getAllTasksById() {
    TodoTaskList todoTaskList = todoService.getTodoList();
    return ResponseEntity.ok().body(todoTaskList);
  }

  @GetMapping("/counttasks")
  public ResponseEntity<Object> getCountOfAllTasks() {
    return ResponseEntity.ok(todoService.getNumberOfTasks());
  }

  @PostMapping("/addtask")
  public ResponseEntity<Object> addTaskToList(@RequestBody TodoTask todoTask) {
    String taskId = todoService.addTaskToList(todoTask);
    return ResponseEntity.ok(taskId);
  }

  @PutMapping("/edittask")
  public ResponseEntity<Object> editTask(@RequestBody TodoTask todoTask) {
    boolean success = todoService.updateTodoList(todoTask);
    return ResponseEntity.ok(success);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteTaskById(@PathVariable String id) {
    todoService.deleteItem(id);
    return ResponseEntity.ok().body(true);
  }
}
