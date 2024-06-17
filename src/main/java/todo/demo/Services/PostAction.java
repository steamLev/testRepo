package todo.demo.Services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import todo.demo.Models.Task;
import todo.demo.Repositories.TaskRepository;
import java.util.List;


@Component
@Slf4j
public class PostAction implements ITaskAction {


    @Autowired
    TaskRepository taskRepository;

    @Override
    public void action(  Task task) {
        try{
            taskRepository.save(task);
        }
        catch (Exception e){log.info("PostAction error");e.printStackTrace();}


    }

    @Override
    public List<Task> get(Task task) {
        return null;
    }


}
