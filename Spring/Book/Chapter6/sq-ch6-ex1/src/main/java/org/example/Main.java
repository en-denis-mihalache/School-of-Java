package org.example;

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CommentService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   public static void main(String[] args) {
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

       CommentService commentService = context.getBean(CommentService.class);

       Comment comment = new Comment();
       comment.setText("Denis <3 Spring");
       comment.setAuthor("Denis");

       commentService.publishComment(comment);
   }
}
