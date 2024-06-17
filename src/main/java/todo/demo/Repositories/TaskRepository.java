package todo.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todo.demo.Models.Task;


@Repository
public interface TaskRepository extends JpaRepository<  Task,Long> {
}
