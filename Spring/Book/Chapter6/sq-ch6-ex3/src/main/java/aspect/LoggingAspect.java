package aspect;

import model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* service..*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
    String methodName=joinPoint.getSignature().getName();
    Object [] arguments=joinPoint.getArgs();

    logger.info("Method "+ methodName + "with arguments: " +Arrays.asList(arguments)+ " will execute");
    Comment comment = new Comment();
    comment.setText("This is another comment!");
    comment.setAuthor("Matei");

    Object[] newArguments={comment};
    Object returnedByMethod = joinPoint.proceed(newArguments);
    logger.info("Method executed and returned: " + returnedByMethod);
    return "FAILED";
    }
}

