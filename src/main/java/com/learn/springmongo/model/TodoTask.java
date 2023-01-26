package com.learn.springmongo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("todo_task")
public class TodoTask {
  @Id private String taskId;
  private String title;
  private String description;
  private boolean isComplete;
  private Date creationDate;
  private Date updationDate;
}
