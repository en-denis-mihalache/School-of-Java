package org.example;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.CommentRepository;
import service.CommentService;
import service.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService = context.getBean(CommentService.class);
        UserService userService = context.getBean(UserService.class);

        boolean b=
                commentService.getCommentRepository() == userService.getCommentRepository();

        System.out.println(b);
    }
}
