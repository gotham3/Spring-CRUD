package com.learn.springmongo.repository;

import com.learn.springmongo.model.TodoTask;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {

  @Autowired MongoTemplate mongoTemplate;

  public TodoTask createTodo(TodoTask todoTask) {
    todoTask.setTaskId(UUID.randomUUID().toString());
    return mongoTemplate.save(todoTask);
  }

  public TodoTask findById(String taskId) {
    return mongoTemplate.findById(taskId, TodoTask.class);
  }

  public List<TodoTask> findAll() {
    return mongoTemplate.findAll(TodoTask.class);
  }

  public void updateById(String taksId, Map<String, Object> dataMap) {}

  public void deleteById(String taskId) {
    Query query = new Query();
    query.addCriteria(Criteria.where("_id").is(taskId));
    mongoTemplate.remove(query, TodoTask.class);
  }
}
