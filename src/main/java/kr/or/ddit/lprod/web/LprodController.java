package kr.or.ddit.lprod.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.service.ILprodService;

@RequestMapping("lprod/")
@Controller
public class LprodController {
	
	@Resource(name = "lprodService")
	private ILprodService lprodService;

	/**
	 * 
	 * Method : userList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param model
	 * @return
	 * Method 설명 : 전체 제품 그룹 리스트 조회
	 */
	@RequestMapping(path = "lprodList", method = RequestMethod.GET)
	public String lprodList(Model model) {
		
		model.addAttribute("lprodList", lprodService.getLprodList());
		
		return "lprod/lprodList";
	}
	
	/**
	 * 
	 * Method : lprodPagingList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param page
	 * @param model
	 * @return
	 * Method 설명 : 제품 그룹 페이징 리스트 조회
	 */
	@RequestMapping(path = "lprodPagingList", method = RequestMethod.GET)
	public String lprodPagingList(Page page, Model model) {
		
		page.setNo("1");
		
		model.addAttribute("pageVo", page);
		  
		Map<String, Object> resultMap = lprodService.getLprodPagingList(page);
		  
		model.addAllAttributes(resultMap);
		
		return "lprod/lprodPagingList";
	}
	
	
}
