package todo.demo.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import todo.demo.Models.Task;
import todo.demo.Repositories.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class GetAction implements ITaskAction{
   @Autowired
    TaskRepository taskRepository;
    @Override
    public void action( Task task) {

    }

    @Override
    public List<Task> get(Task task) {

        List<Task> taskList= new ArrayList<>();
        try{
            if(Optional.ofNullable(task.getId()).isEmpty()){
                return taskRepository.findAll();}
            else {
                taskList.add(taskRepository.findById(task.getId()).get());
              }
        }
        catch (Exception e){log.info("GetAction get error");e.printStackTrace();}
        return taskList;
    }




}
