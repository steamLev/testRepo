package todo.demo.Controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.demo.Models.Task;
import todo.demo.Services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
@RestController
public class TaskControllers {

ExecutorService service=   Executors.newFixedThreadPool(3);

    @Autowired
    PostAction postAction;

    @Autowired
    DeleteAction deleteAction;

    @Autowired
    PutAction putAction;

@Autowired
    TaskService taskService;

@PostMapping(value = "/create/{desc}")
public void createTask(@PathVariable("desc") String desc){
     Task task=new Task();
//создаем задание
    try{
        task.setStatus(false);
        task.setDesc(desc);
        taskService.todoAction( postAction,task);
    }
    catch (Exception e){log.info("deleteTask error");e.printStackTrace();}

}

@GetMapping(value = "/get/all")
public List<Task> getTask(){
    List<Task> list=new ArrayList<>();
    //выгружаем все  задания в многопоточном режиме
    try{
        Callable<List<Task>> callableTask = () -> {return taskService.getTask( new Task());};
           list=service.submit(callableTask).get(3000, TimeUnit.SECONDS);
    }
    catch (Exception e){log.info("getTask error");
         e.printStackTrace();}

    return list;
}

    @GetMapping(value = "/get/{id}")
    public List<Task> getTaskId(@PathVariable("id") Long id){
        Task task=new Task();
        List<Task> taskList=new ArrayList<>();
        //выгружаем    задание по id
        try{
            task.setId(id);
             taskList=   taskService.getTask(task);
        }
        catch (Exception e){log.info("getTaskId error");e.printStackTrace();}
        return taskList;
    }

@DeleteMapping(value = "/delete/{id}")
public void deleteTask(@PathVariable("id") Long id){
    Task task=new Task();
    //удаляем    задание по id
    try{
        task.setId(id);
        taskService.todoAction( deleteAction,task);
    }
    catch (Exception e){log.info("deleteTask error");e.printStackTrace();}
}

@PutMapping(value = "/put/{id}/{desc}/{status}")
public void putTask(@PathVariable("id") Long id,
        @PathVariable("desc") String desc,
                    @PathVariable("status") Boolean status){
    //вносим изменения в     задание по id
    try{
        Task task=new Task(id,desc,status);
        taskService.todoAction( putAction,task);
    }
    catch (Exception e){log.info("putTask error");e.printStackTrace();}


}
}
