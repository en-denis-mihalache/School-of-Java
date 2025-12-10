
import config.AppConfig;
import model.Employee;
import model.Task;
import service.AssignmentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class TaskEngineApplication {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            AssignmentService assignmentService = context.getBean(AssignmentService.class);

            Map<Task, Employee> assignment = assignmentService.assignAllTasks();

            assignment.forEach((task, employee) -> {
                String employeeName = (employee != null) ? employee.getName() : "No suitable employee";
                System.out.println(task.getTaskName() + " -> " + employeeName);
            });
        }
    }
}
