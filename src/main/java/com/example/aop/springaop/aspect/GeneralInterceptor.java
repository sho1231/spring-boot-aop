package com.example.aop.springaop.aspect;

import com.example.aop.springaop.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GeneralInterceptor {

    @Pointcut("execution(* com.example.aop.springaop.controller.*.*(..))")
    public void loggingPointCut() {

    }

    /*@Before("loggingPointCut()")
    public void beforeMethod (JoinPoint joinPoint) {
        log.info("Before Signature {}",joinPoint.getSignature());
    }
    @After("loggingPointCut()")
    public void afterMethod (JoinPoint joinPoint) {
        log.info("After Signature {}",joinPoint.getSignature());
    }*/

    @AfterReturning(value="execution(* com.example.aop.springaop.controller.*.*(..))",returning = "employee")
    public void afterReturningMethod(JoinPoint joinPoint, Employee employee) {
        log.info("Signature {}",joinPoint.getSignature());
        log.info("After returning {}",employee);
    }

    @AfterThrowing(value="execution(* com.example.aop.springaop.controller.*.*(..))",throwing = "e")
    public void afterReturningMethod(JoinPoint joinPoint, Exception e) {
        log.info("After returning {}",e.getMessage());
    }
    
}
