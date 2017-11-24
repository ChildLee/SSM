package cn.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    private static Logger logger = LogManager.getLogger("log");

    @Pointcut("execution(* cn.aop.Sa.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void beforeLog() {
        logger.info("---------------执行前---------------");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowingLog() {
        logger.error("报错后日志");
    }

    @After("pointCut()")
    public void afterLog() {
        logger.info("---------------执行后日志---------------");
    }

    @AfterReturning("pointCut()")
    public void afterReturningLog() {
        logger.info("---------------执行成功后日志---------------");
    }

    //环绕切面不管前后总是先执行,先捕捉错误
    @Around("pointCut()")
    public Object aroundLog(ProceedingJoinPoint joinpoint) {
        logger.info("---------------环绕前---------------");
        Object object = null;
        try {
            object = joinpoint.proceed();
        } catch (Throwable throwable) {
            logger.info("=环绕报错=" + throwable);
        }
        logger.info("---------------环绕后---------------");
        return object;
    }
}
