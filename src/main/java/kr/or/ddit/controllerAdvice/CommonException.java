package kr.or.ddit.controllerAdvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonException {

	private static final Logger logger = LoggerFactory.getLogger(CommonException.class);
	
   @ExceptionHandler({ArithmeticException.class})
   public String exceptionHandler() {
	   
	   logger.debug("exceptionHandler()");
	   
	   return "error/arith";
   }

}
