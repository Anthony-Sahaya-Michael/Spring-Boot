package com.example.busbooking.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectConfig {
    Logger logger=LoggerFactory.getLogger(getClass());

    @Before(value="execution(* com.example.busbooking.Controller.*.*(..)) ")
    public void beforeAdvice (JoinPoint joinpoint)
    {	
        logger.info("Inside Before Advice");
    }

    @After(value="execution(* com.example.busbooking.Controller.*.*(..)) ")
    public void afterAdvice (JoinPoint joinpoint)
    {	
        logger.info("Inside After Advice");
    }
}
