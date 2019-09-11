package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfilingAspect {

	private static final Logger logger = LoggerFactory.getLogger(ProfilingAspect.class);
	
	public void before(JoinPoint join) {
		logger.debug("profilingAspect.before()");
	}
	
	public void after(JoinPoint join) {
		logger.debug("profilingAspect.after()");
	}
	
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// 시작시간
		long stDt = System.nanoTime();
		
		// 메소드 실행
		Object[] args = joinPoint.getArgs();
		Object retObj = joinPoint.proceed(args);
		
		// 종료시간
		long edDt = System.nanoTime();
		
		logger.debug("edDt - stDt : {}", edDt - stDt);
		
		return retObj;
	}
}
