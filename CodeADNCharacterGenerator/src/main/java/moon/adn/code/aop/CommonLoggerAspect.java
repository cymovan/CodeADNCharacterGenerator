package moon.adn.code.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CommonLoggerAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();

		long executionTime = System.currentTimeMillis() - start;

		logger.debug("{} executed in {} ms", joinPoint.getSignature(), executionTime);
		return proceed;
	}
}
