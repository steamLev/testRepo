package todo.demo.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.demo.Models.Task;

import java.util.List;

@Service
@Slf4j
public class TaskService {
    //общий сервисный слой для postaction putaction deletetaction getaction
    @Autowired
    GetAction getAction;
    public void todoAction( ITaskAction iTaskAction,Task task){

        try{
            iTaskAction.action( task);
        }
        catch (Exception e){log.info("TaskService todoAction error");e.printStackTrace();}
    }

    public List<Task> getTask(Task task ){
      return   getAction.get(task);
    }
}
