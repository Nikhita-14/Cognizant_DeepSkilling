package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect // Marks this class as an Aspect
public class LoggingAspect {

    // 1. Before Advice: Executes right before any method in the service package starts
    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(">>> [AOP START LOG] Preparing to execute: "
                + joinPoint.getSignature().getName() + " <<<");
    }

    // 2. After Advice: Executes right after any method in the service package completes
    @After("execution(* com.library.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println(">>> [AOP END LOG] Finished executing: "
                + joinPoint.getSignature().getName() + " <<<");
    }
}