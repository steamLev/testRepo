package todo.demo.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import todo.demo.Models.Task;
import todo.demo.Repositories.TaskRepository;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Component
public class DeleteAction implements ITaskAction {

    @Autowired
    TaskRepository taskRepository;


    @Override
    public void action(Task task) {
try{
    taskRepository.deleteById(task.getId());
}
catch (Exception e){log.info("DeleteAction error");e.printStackTrace();}


    }

    @Override
    public List<Task> get(Task task) {
        return null;
    }
}
