package todo.demo;

import nonapi.io.github.classgraph.utils.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import todo.demo.Models.Task;
import todo.demo.Repositories.TaskRepository;
import todo.demo.Services.GetAction;
import todo.demo.Services.PostAction;
import todo.demo.Services.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class DemoApplicationTests {

}
