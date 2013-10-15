package com.impetus.ee.common.logging;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class TeamPlannerLogger { 

	private final Logger log = Logger.getLogger(this.getClass());
	@Around("execution(* com.impetus.ee.services..*.*(..))")
	public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable 
	{
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object retVal = joinPoint.proceed();
		stopWatch.stop();
		StringBuffer logMessage = new StringBuffer();
		logMessage.append(joinPoint.getTarget().getClass().getName());
		logMessage.append(".");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append("(");
		// append args
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < args.length; i++) 
		{
			logMessage.append(args[i]).append(",");
		}
		if (args.length > 0) {
			logMessage.deleteCharAt(logMessage.length() - 1);
		}
		logMessage.append(")");
		logMessage.append(" execution time: ");
		logMessage.append(stopWatch.getTotalTimeMillis());
		logMessage.append(" ms\n");
		logMessage.append("return value: "+retVal);
		log.info(logMessage.toString());
		return retVal;
	}
	
	@AfterThrowing(pointcut="execution(* com.impetus.ee.services..*.*(..))", throwing="e")
	public void afterThrowing(JoinPoint joinPoint, Throwable e) {
		Signature signature = joinPoint.getSignature();
	    String methodName = signature.getName();
	    String stuff = signature.toString();
	    String arguments = Arrays.toString(joinPoint.getArgs());
	    log.info("Caught exception in method: "
	        + methodName + " with arguments "
	        + arguments + "\nand the full toString: " + stuff + "\nthe exception is: "
	        + e.getMessage(), e);
	  }
}

