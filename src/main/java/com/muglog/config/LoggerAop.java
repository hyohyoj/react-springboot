package com.muglog.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggerAop {

    private static final Logger log = LoggerFactory.getLogger(LoggerAop.class);

//    @Around("execution(* com.muglog.controller..*Controller.*(..))"
//            +" || execution(* com.muglog.service..*Service*.*(..))"
//            +" || execution(* com.muglog.repository..*Repository.*(..))")
    @Around("execution(* com.muglog.repository..*Repository.*(..))")
    public Object logPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //객체명
        String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();

        //proceedingJoinPoint.getSignature().getName() <- 실행 메서드명
        //Arrays.toString(proceedingJoinPoint.getArgs()) <- 파라미터
        log.info("[METHOD] " + type+"."+proceedingJoinPoint.getSignature().getName()+"() ==================================");
        //log.info("Argument/Parameter : "+ Arrays.toString(proceedingJoinPoint.getArgs()));//<-파라미터

        return proceedingJoinPoint.proceed();
    }

}