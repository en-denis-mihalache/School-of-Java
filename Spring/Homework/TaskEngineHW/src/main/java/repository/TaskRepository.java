package repository;

import model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    List<Task> tasks = new ArrayList<>(
            List.of(
                    new Task("Console Application","Java" ),
                    new Task("Website","JavaScript" ),
                    new Task("Android Application", "Android"),
                    new Task("Video Game", "C++")
            ));

    public List<Task> findAll() {
        return tasks;
    }
}
