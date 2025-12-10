package service;

import model.Employee;
import model.Task;
import repository.EmployeeRepository;
import repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AssignmentService {
    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;
    private final SimpleAssignmentStrategy simpleAssignmentStrategy;

    public AssignmentService(EmployeeRepository employeeRepository,
                             TaskRepository taskRepository,
                             SimpleAssignmentStrategy simpleAssignmentStrategy) {
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
        this.simpleAssignmentStrategy = simpleAssignmentStrategy;
    }

    public Map<Task, Employee> assignAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return simpleAssignmentStrategy.assignTasks(tasks);
    }
}
