package com.example.aop.springaop.aspect;

import com.example.aop.springaop.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GeneralInterceptor {

//    @Pointcut("execution(* com.example.aop.springaop.controller.*.*(..))")
//    @Pointcut("within(com.example.aop.springaop.controller.*)")
    @Pointcut("this(com.example.aop.springaop.service.EmployeeService)")
    public void loggingPointCut() {

    }

    /*@Before("loggingPointCut()")
    public void beforeMethod (JoinPoint joinPoint) {
        log.info("Before Signature {}",joinPoint.getSignature());
    }
    @After("loggingPointCut()")
    public void afterMethod (JoinPoint joinPoint) {
        log.info("After Signature {}",joinPoint.getSignature());
    }

    @AfterReturning(value="execution(* com.example.aop.springaop.controller.*.*(..))",returning = "employee")
    public void afterReturningMethod(JoinPoint joinPoint, Employee employee) {
        log.info("Signature {}",joinPoint.getSignature());
        log.info("After returning {}",employee);
    }

    @AfterThrowing(value="execution(* com.example.aop.springaop.controller.*.*(..))",throwing = "e")
    public void afterReturningMethod(JoinPoint joinPoint, Exception e) {
        log.info("After returning {}",e.getMessage());
    }

     */

    @Around("loggingPointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("Request will be returned before executing proceed {}",proceedingJoinPoint.getSignature());
        Object object = proceedingJoinPoint.proceed();
        log.info("Response will be returned after executing proceed {}",proceedingJoinPoint.getSignature());
        return object;
    }

    
}
