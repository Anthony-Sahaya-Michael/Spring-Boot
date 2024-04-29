package com.example.onetomanyuniauthor.config;

import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Configuration  //@Configuration annotation which indicates that the class has @Bean definition methods.
@Aspect    //Contains classes like JoinPoint, Point cut, @Before, @After etc..

public class AspectConfig {
    Logger logger=LoggerFactory.getLogger(getClass());

    // Executes before the method
    @Before(value="execution(* com.example.onetomanyuniauthor.controller.*.*(..)) ")
public void beforeAdvice (JoinPoint joinpoint)
{	logger.info("Inside Befroe Advice");
}
//Executes after the method
@After(value="execution(* com.example.onetomanyuniauthor.controller.*.*(..)) ")
public void afterAdvice (JoinPoint joinpoint)
{	logger.info("Inside After Advice");
}
// //Executes before the method along with the parameter
 @Before(value="execution(* com.example.onetomanyuniauthor.controller.*.*(..)) and args(object) ")
public void beforeAdviceWith1Param (JoinPoint joinpoint, Object object)
{	logger.info("Inside Befroe Advice with parameter"+object);
}

// @Before(value="execution(* com.example.onetomanyuniauthor.controller.*.*(..))")
// public void beforeAdviceWith1Param (JoinPoint joinpoint)
// {	Object args[]=joinpoint.getArgs();
//     for(Object arg:args)
//      System.out.println(arg.toString());
//     logger.info("Inside Befroe Advice with parameter"+args);
// }


//Executes afterReturning the value to called the method(which performs prior to After method)
@AfterReturning(value="execution(* com.example.onetomanyuniauthor.controller.AuthorController.getAuthors(..)) ")
public void afterReturningAdvice (JoinPoint joinpoint)
{	logger.info("Inside AfterReturning Advice");
}

//Executes a a method by allowing the advice to control the method execution. 
// It is more powerful than other types of advice because it has the ability to control both the input and output of the target method. 
// @Around (value="execution(* com.example.onetomanyuniauthor.controller.*.*(..)) ")
// public Object  newAround(ProceedingJoinPoint joinpoint) throws Throwable
// {	System.out.println("Before Executing Method: "+joinpoint.getSignature().toString());
//     Object result=joinpoint.proceed();
//     System.out.println("After Executing Method: "+joinpoint.getSignature().toString());    
//     return result;
// }

}
