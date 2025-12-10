package service;

import model.Employee;
import model.Task;
import repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SimpleAssignmentStrategy {

    private final EmployeeRepository employeeRepository;

    public SimpleAssignmentStrategy(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Map<Task, Employee> assignTasks(List<Task> tasks) {
        Map<Task, Employee> assignment = new HashMap<>();

        for (Task task : tasks) {
            Employee employee = employeeRepository.findEmployeeBySkill(task.getSkill());
            assignment.put(task, employee);
        }

        return assignment;
    }
}