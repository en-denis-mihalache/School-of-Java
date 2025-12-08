package service;

import java.util.logging.Logger;
import model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment){
        logger.info("Publishing comment: "+ comment.getText());
        return "SUCCESS";
    }
}
