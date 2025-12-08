package org.example;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import service.CommentService;


public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService cs1 = c.getBean("commentService", CommentService.class);
        CommentService cs2 = c.getBean("commentService", CommentService.class);

        boolean b1 = cs1 == cs2;

        System.out.println(b1);
    }
}