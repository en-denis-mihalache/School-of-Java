package org.example;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CommentService;

import javax.sound.sampled.Port;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService = (CommentService) context.getBean("commentService");
        CommentService commentService1 = (CommentService) context.getBean("commentService");

        boolean b1 = commentService1==commentService;

        System.out.println(b1);
    }
}
