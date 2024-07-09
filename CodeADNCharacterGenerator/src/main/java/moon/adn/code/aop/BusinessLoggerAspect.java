package moon.adn.code.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BusinessLoggerAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("execution (* moon.adn.code.character.generator.*.*.*(..))")
	public Object logAroundBusinessMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		logger.info("Start executing : " + className + "." + methodName);

		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - start;

		logger.info("End   executing : " + className + "." + methodName + " in " + executionTime + "ms");
		return proceed;
	}
}