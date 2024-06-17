package todo.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import todo.demo.Models.Task;
import todo.demo.Repositories.TaskRepository;
import todo.demo.Services.PostAction;
import todo.demo.Services.PutAction;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class PostActionTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private PostAction postAction;

    @InjectMocks
    private PutAction putAction;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAction_Success() {
        Task task = new Task();
        postAction.action(task);
        verify(taskRepository, times(1)).save(task);

        // Пример использования assert для проверки успешного выполнения
        assertDoesNotThrow(() -> postAction.action(task));
    }

    @Test
    public void testAction_Exception() {
        Task task = new Task();
        doThrow(new RuntimeException()).when(taskRepository).save(task);

        // Проверка, что метод обрабатывает исключение и не бросает его дальше
        assertDoesNotThrow(() -> postAction.action(task));

        verify(taskRepository, times(1)).save(task);
    }

    @Test
    public void testGet() {
        Task task = new Task( );
        
        assertNull( postAction.get(task));
    }

    @Test
    public void testPut() {
        Task task = new Task( );
        putAction.action(task);
        verify(taskRepository, times(1)).save(task);

        // Пример использования assert для проверки успешного выполнения
        assertDoesNotThrow(() -> putAction.action(task));
    }
}

