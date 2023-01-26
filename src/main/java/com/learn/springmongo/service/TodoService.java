package com.learn.springmongo.service;

import com.learn.springmongo.model.TodoTask;
import com.learn.springmongo.model.TodoTaskList;
import com.learn.springmongo.repository.TodoRepository;
import java.util.List;
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
  //
  //    public long UpdateTodoItem(long todoId, Todo todo){
  //
  //        long updateTodoId=0;
  //        //Retrieve the value you want to update
  //        try {
  //            Todo updatedTodo=todoRepository.findById(todoId).get();
  //
  //            updatedTodo.setTodoTitle(todo.getTodoTitle());
  //            updatedTodo.setTodoDescription(todo.getTodoDescription());
  //            updatedTodo.setTodoDate(todo.getTodoDate());
  //            updatedTodo.setComplete(todo.isComplete());
  //            todoRepository.save(updatedTodo);
  //            updateTodoId=updatedTodo.getTodoId();
  //            return updateTodoId;
  //        } catch (Exception e) {
  //            e.printStackTrace();
  //        }
  //        return updateTodoId;
  //
  //    }

  public boolean isTodoTaskValid(String taskId) {
    return todoRepository.findById(taskId) != null;
  }

  public long getNumberTodoItem() {
    return todoRepository.findAll().size();
  }
}
