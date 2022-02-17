package com.home.mysite07.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParametterAop {

    @Pointcut("execution(* com.home.mysite07.controller..*.*(..))")
    private void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("들어갈때 정보 실행+++++++++++++++++++");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("[메서드이름] : " + method.getName());
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            System.out.println("[타입] : " + obj.getClass().getSimpleName());
            System.out.println("[값] : " + obj);
        }

    }

    @AfterReturning(value = "pointCut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("나올때 정보 실행+++++++++++++++++++");
        System.out.println("[출력객체] : " + returnObj);

    }
}
