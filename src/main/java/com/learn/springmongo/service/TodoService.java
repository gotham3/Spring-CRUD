package com.learn.springmongo.service;

import com.learn.springmongo.model.TodoTask;
import com.learn.springmongo.model.TodoTaskList;
import com.learn.springmongo.repository.TodoRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TodoService {
  @Autowired private TodoRepository todoRepository;

  public TodoTaskList getTodoList() {
    List<TodoTask> todoList = todoRepository.findAll();
    return TodoTaskList.builder().count(todoList.size()).taskList(todoList).build();
  }

  public TodoTask getTaskById(String taskId) {
    return todoRepository.findById(taskId);
  }

  public String addTaskToList(TodoTask todoTask) {
    TodoTask todo = todoRepository.createTodo(todoTask);
    return todo.getTaskId();
  }

  public void deleteItem(String taskId) {
    todoRepository.deleteById(taskId);
    log.info("Item with id = {} removed from the list.", taskId);
  }

  public boolean updateTodoList(TodoTask todoTask) {
    Map<String, Object> dataMap = new HashMap<>();
    if (todoTask.getTitle() != null) {
      dataMap.put("title", todoTask.getTitle());
    }
    if (todoTask.getDescription() != null) {
      dataMap.put("description", todoTask.getDescription());
    }
    dataMap.put("isComplete", todoTask.isComplete());

    return todoRepository.updateById(todoTask.getTaskId(), dataMap);
  }

  public long getNumberOfTasks() {
    return todoRepository.findAll().size();
  }
}
