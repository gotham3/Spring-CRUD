package com.learn.springmongo.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoTaskList {
  private long count;
  private List<TodoTask> taskList;
}
