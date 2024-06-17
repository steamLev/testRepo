package todo.demo.Services;

import todo.demo.Models.Task;

import java.util.List;

public interface ITaskAction {
    public void action( Task task);


    public List<Task> get(Task task);
}
