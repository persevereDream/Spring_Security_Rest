package com.cc.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.cc.web.controller.UserController.*(..))")
    /**
     * pjp  为被拦截的对象
     */
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");

        Object[] args = pjp.getArgs();
        for (Object arg:args) {
            System.out.println("arg is "+ arg);
        }

        long start = new Date().getTime();
        Object proceed = pjp.proceed(); //被拦截的方法
        System.out.println("time aspect 耗时:"+(new Date().getTime()-start));
        System.out.println("time aspect end");
        return proceed;
    }

}


