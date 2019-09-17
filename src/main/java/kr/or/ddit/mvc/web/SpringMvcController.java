package kr.or.ddit.mvc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("mvc")
@Controller
public class SpringMvcController {

	private static final Logger logger = LoggerFactory.getLogger(SpringMvcController.class);
	
	/**
	 * 
	 * Method : view
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @return
	 * Method 설명 : mvc 어노테이션 테스트 view
	 */
	@RequestMapping("view")
	public String view() {
		return "mvc/view";
	}
	
	/**
	 * 
	 * Method : requestParam
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param user
	 * @param page
	 * @return
	 * Method 설명 : @RequestParam 어노테이션 테스트
	 */
	@RequestMapping("requestParam")
	public String requestParam(@RequestParam(name = "userId") String user, 
							   @RequestParam(defaultValue = "10") int page) {
		logger.debug("userId : {}", user);
		logger.debug("page : {}", page);
		
		return "mvc/view";
	}
	
	// /mvc/
	@RequestMapping("/path/{subpath}")
	public String requestPath(@PathVariable(name = "subpath") String subpath) {
		logger.debug("subpath : {}", subpath);
		
		return "mvc/view";
	}
}
