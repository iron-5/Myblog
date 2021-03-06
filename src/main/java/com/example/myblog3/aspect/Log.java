package com.example.myblog3.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class Log {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value = "execution(* com.example.myblog3.controller.*.*(..))")
    public void log(){
        //空方法
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attribute.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, method, args);
        logger.info("requestLog = {}", requestLog);
    }

    @AfterReturning(pointcut = "log()",returning = "result")
    public void doAfterReturning(Object result){
        logger.info("result = {}", result);
    }

    @AllArgsConstructor
    @Data
    private class RequestLog{
        private String url;
        private String ip;
        private String method;
        private Object[] args;
    }
}
