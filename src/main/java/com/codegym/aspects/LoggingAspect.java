package com.codegym.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    @AfterReturning(pointcut = "execution(* com.codegym.services.*.*(..))", returning = "result")
    public void log(JoinPoint joinPoint, Object result) {
        System.out.println("[MyLogger] @AfterReturning");
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[MyLogger] executed %s.%s [args=%s]", className, methodName, args));
        System.out.println("[MyLogger] Result: " + result.toString());
    }

    @AfterThrowing(pointcut = "execution(* com.codegym.services.*.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        System.out.println("[MyLogger] @AfterThrowing");
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[MyLogger] executed %s.%s [args=%s]", className, methodName, args));
        System.out.println("[MyLogger] Exception: " + exception.getMessage());
    }

}
