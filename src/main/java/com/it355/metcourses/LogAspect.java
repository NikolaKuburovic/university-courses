package com.it355.metcourses;

import org.aspectj.lang.annotation.Aspect;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
/**
 *
 * @author Nikola Kuburovic 1095
 */
@Aspect
public class LogAspect {
    
    private Log log = LogFactory.getLog(this.getClass());
    
        @Before("execution(* com.it355.metcourses.ProfesorController.*(..))")
        public void logBeforeProfesor(JoinPoint joinPoint){
            log.info("Strana " + joinPoint.getSignature().getName() + " ce se pokrenuti.");
        }
        @After("execution(* com.it355.metcourses.ProfesorController.*(..))")
        public void logAfterProfesor(JoinPoint joinPoint){
            log.info("Pokretanje strane " + joinPoint.getSignature().getName() + " je zavrseno.");
        }
        
        @Before("execution(* com.it355.metcourses.AsistentController.*(..))")
        public void logBeforeAsistent(JoinPoint joinPoint){
            log.info("Strana " + joinPoint.getSignature().getName() + " ce se pokrenuti.");
        }
        @After("execution(* com.it355.metcourses.AsistentController.*(..))")
        public void logAfterAsistent(JoinPoint joinPoint){
            log.info("Pokretanje strane " + joinPoint.getSignature().getName() + " je zavrseno.");
        }
}
