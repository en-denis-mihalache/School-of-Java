package repository;

import model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    List<Employee> employees = new ArrayList<>(
            List.of(
                    new Employee("Mirel", new ArrayList<>(List.of("Java", "Springboot"))),
                    new Employee("Alina", new ArrayList<>(List.of("C++", "Android"))),
                    new Employee("George", new ArrayList<>(List.of("Java","Kotlin"))),
                    new Employee("Alexandra", new ArrayList<>(List.of("Android","JavaScript")))
            ));


    public Employee findEmployeeBySkill(String skill) {
        return employees.stream()
                .filter(e -> e.getSkills().contains(skill))
                .findFirst()
                .orElse(null);
    }

}
