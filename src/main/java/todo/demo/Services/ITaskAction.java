package todo.demo.Services;

import todo.demo.Models.Task;

import java.util.List;

public interface ITaskAction {
      void action( Task task);


      List<Task> get(Task task);
}
