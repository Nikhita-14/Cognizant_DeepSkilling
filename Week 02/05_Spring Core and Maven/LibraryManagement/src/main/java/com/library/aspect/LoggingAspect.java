package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

    // This method wraps around your targeted methods to calculate execution time
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 1. Let the original business method execute
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        // 2. Print out the logs automatically
        System.out.println(">>> [AOP LOG] Method " + joinPoint.getSignature().getName()
                + " executed in " + executionTime + " ms <<<");

        return result;
    }
}