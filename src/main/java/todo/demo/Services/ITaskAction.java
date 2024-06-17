package todo.demo.Services;

import todo.demo.Models.Task;

import java.util.List;

public interface ITaskAction {

      //общий интерфейс для postaction putaction deletetaction getaction
      void action( Task task);


      List<Task> get(Task task);
}
