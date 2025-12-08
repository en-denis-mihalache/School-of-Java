package model;

import config.ProjectConfig;
import org.example.Main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CommentService;

import java.util.logging.Logger;

public class Comment {
    private String text;
    private String author;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}