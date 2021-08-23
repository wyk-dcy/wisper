package com.wyk.wisper.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author wuyongkang
 * @date 2021年07月14日 14:23
 */
@Aspect
@Component
public class ConfigurationStateAspect {
    @Around("execution(@(com.wyk.wisper.aspect.ApiLog) * *.*(..))")
    public boolean aroundConfigurationModifiedMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--------------------------------");
        System.out.println(joinPoint.getTarget());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getKind());

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null)
        {
            ApiLog apiLog=  method.getAnnotation(ApiLog.class);
            System.out.println("切入方法注解的title:"+apiLog.title());
        }
        //4. 获取方法的参数
        Object[] args = joinPoint.getArgs();
        for(Object o :args){
            System.out.println("切入方法的参数："+o);
        }

        System.out.println("--------------------------------");
        boolean ret = (boolean) joinPoint.proceed();
        return ret;
    }
}