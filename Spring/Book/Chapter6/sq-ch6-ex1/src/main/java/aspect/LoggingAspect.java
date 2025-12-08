package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* service..*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Logging Aspect started");

        Object result = joinPoint.proceed();

        System.out.println("Logging Aspect finished");
    }
}
