package com.suninvirgo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());
    @Pointcut("execution(* com.suninvirgo.customer.*.*(..))")
    private void forCustomerPackage(){}

    @Before("forCustomerPackage()")
    public void before(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        logger.info("==> @Before advice called method " + method);

        Object[] args = joinPoint.getArgs();
        for(Object arg: args){
            logger.info("==> argument: " + arg);
        }
    }

    @AfterReturning(pointcut = "forCustomerPackage()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("==> @AfterReturning advice called method " + method);
        logger.info("==> result: " + result);
    }
}
