package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // Before Advice
    @Before("execution(* com.library.service.BookService.*(..))")
    public void beforeMethod() {
        System.out.println("===== Before Method Execution =====");
    }

    // After Advice
    @After("execution(* com.library.service.BookService.*(..))")
    public void afterMethod() {
        System.out.println("===== After Method Execution =====");
    }

    // Around Advice (Execution Time)
    @Around("execution(* com.library.service.BookService.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        System.out.println("Execution Time : "
                + (endTime - startTime)
                + " ms");

        return result;
    }
}