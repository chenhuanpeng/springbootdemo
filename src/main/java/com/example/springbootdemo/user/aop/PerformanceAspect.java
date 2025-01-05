package com.example.springbootdemo.user.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* com.example.springbootdemo.user.service.impl.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("方法名称：" + joinPoint.getSignature().getName() + " 开始执行");
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed(); // 执行目标方法

        long executionTime = System.currentTimeMillis() - start;

        System.out.println("方法名称：" + joinPoint.getSignature().getName() + " 方法执行时间：" + executionTime + "ms");
        return proceed;
    }
}

