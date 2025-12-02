package main;

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CommentSerive;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var comment = new Comment();
        comment.setAuthor("Denis");
        comment.setText("Comentariu");

        var commentService = context.getBean(CommentSerive.class);
        commentService.publishComment(comment);
    }
}
