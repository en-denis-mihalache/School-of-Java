package service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
public class CommentService {

    public CommentService() {
        System.out.println("CommentService init!");
    }
}
