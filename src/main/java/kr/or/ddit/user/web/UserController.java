package kr.or.ddit.user.web;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.service.IUserService;

@RequestMapping("user/")
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name = "userService")
	private IUserService userService;
	
	/**
	 * 
	 * Method : userView
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 상세화면 요청
	 */
	// 사용자가 localhost:8081/spring/user/view.do
	@RequestMapping("view.do")
	public String userView() {
		logger.debug("userController.userView()");
		return "user/view";
		
		// prefix + viewName + suffix
		// W+
	}
	
	/**
	 * 
	 * Method : userList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param model
	 * @return
	 * Method 설명 : 사용자 전체 리스트 조회
	 */
	@RequestMapping(path = "userList", method = RequestMethod.GET)
	public String userList(Model model) {
		
		model.addAttribute("userList", userService.getUserList());
		
		return "user/userList";
	}
	
	/**
	 * 
	 * Method : userListOnlyHalf
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param model
	 * @return
	 * Method 설명 : 사용자 50명 조회
	 */
	@RequestMapping(path = "userListOnlyHalf", method = RequestMethod.GET)
	public String userListOnlyHalf(Model model) {
	      
		model.addAttribute("userList", userService.getUserListOnlyHalf());
		
		return "user/userListOnlyHalf";
	}
	
	/**
	 * 
	 * Method : userPagingList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param model
	 * @param page
	 * @return
	 * Method 설명 : 사용자 페이징 리스트 조회
	 */
	@RequestMapping(path = "userPagingList", method = RequestMethod.GET)
	public String userPagingList(Model model, Integer page, Integer pagesize) {

	    page = page == null ? 1 : page;
	    pagesize = pagesize == null ? 10 : pagesize;
		
		Page p = new Page(page, pagesize);
		
		model.addAttribute("pageVo", p);
		  
		Map<String, Object> resultMap = userService.getUserPagingList(p);
		  
		model.addAttribute("userList", resultMap.get("userList"));
		model.addAttribute("paginationSize", resultMap.get("paginationSize"));
		
		return "user/userPagingList";
	}
}
