package org.example;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.CommentRepository;
import service.CommentService;
import service.UserService;

public class Main{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService s1 = c.getBean(CommentService.class);
        UserService s2 = c.getBean(UserService.class);

        boolean b = s1.getCommentRepository()==s2.getCommentRepository();

        System.out.println(b);
    }
}