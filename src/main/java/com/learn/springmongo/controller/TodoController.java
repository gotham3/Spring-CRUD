package com.learn.springmongo.controller;

import com.learn.springmongo.model.TodoTask;
import com.learn.springmongo.model.TodoTaskList;
import com.learn.springmongo.service.TodoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo/")
@Slf4j
@OpenAPIDefinition(
    info =
        @Info(
            title = "Todo tasks service APIs",
            description = "Documentation of Todo tasks application APIs"))
public class TodoController {
  @Autowired private TodoService todoService;

  @Operation(summary = "Get task details by ID")
  @GetMapping("/{id}")
  public ResponseEntity<Object> getTaskById(@PathVariable String id) {
    TodoTask todoTask = todoService.getTaskById(id);
    return ResponseEntity.ok().body(todoTask);
  }

  @Operation(summary = "Get all task details")
  @GetMapping("/")
  public ResponseEntity<Object> getAllTasks() {
    TodoTaskList todoTaskList = todoService.getTodoList();
    return ResponseEntity.ok().body(todoTaskList);
  }

  @Operation(summary = "Get total number of tasks")
  @GetMapping("/counttasks")
  public ResponseEntity<Object> getCountOfAllTasks() {
    return ResponseEntity.ok(todoService.getNumberOfTasks());
  }

  @Operation(summary = "Create new task")
  @PostMapping("/addtask")
  public ResponseEntity<Object> addTaskToList(@RequestBody TodoTask todoTask) {
    String taskId = todoService.addTaskToList(todoTask);
    return ResponseEntity.ok(taskId);
  }

  @Operation(summary = "Edit task details")
  @PutMapping("/edittask")
  public ResponseEntity<Object> editTask(@RequestBody TodoTask todoTask) {
    boolean success = todoService.updateTodoList(todoTask);
    return ResponseEntity.ok(success);
  }

  @Operation(summary = "Delete task by ID")
  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteTaskById(@PathVariable String id) {
    todoService.deleteItem(id);
    return ResponseEntity.ok().body(true);
  }
}
