package kr.or.ddit.mvc.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.mvc.model.Main;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.FileUtil;
import kr.or.ddit.util.model.FileInfo;

@SessionAttributes("rangers")
@RequestMapping("mvc")
@Controller
public class SpringMvcController {
   
   private static final Logger logger = LoggerFactory.getLogger(SpringMvcController.class);
   
   //@RequestMapping이 붙은 메소드가 실행되기 전에 @ModelAttribute 메소드가 먼저 실행되고
   // 해당 메소드가 리턴하는 값을 Model 객체에 자동으로 넣어준다
   // 해당 컨트롤러에 대해서만 처리
   @ModelAttribute("rangers")
   public List<String> rangers(){
	   
	  logger.debug("rangers()");
	   
	  // db 조회 작업..... : 부하가 생각보다 클 수 가 있다.
      List<String> rangers = new ArrayList<String>();
      rangers.add("brown");
      rangers.add("sally");
      rangers.add("cony");
      
      return rangers;
   }
   
   
   /**
   * Method : view
   * 작성자 : 김혜인
   * 변경이력 :
   * @return
   * Method 설명 : mvc 어노테이션 테스트 view
   */
   @RequestMapping("view")
   public String view(Model model,
               @ModelAttribute("rangers") List<String> rangers2,
               @SessionAttribute(name = "S_USERVO", required = false) User user) {
      /*
       * [메소드 인자]에 사용된 @ModelAttribute
       * [메소드]에 의해 Model에 설정된 속성 값을 메소드 인자에 주입
       * 만약 Model에 해당 속성이 없을 경우 빈 객체를 생성해서 Model 어쩌고
       * --Model객체에 추가가 되었다
       */
      
      List<String> rangers = (List<String>) model.asMap().get("rangers");
      logger.debug("rangers : {}", rangers);
      logger.debug("rangers2 : {}", rangers2);
      logger.debug("S_USERVO : {}", user);
      
      return "mvc/view";
   }
   
   
   
   /**
   * Method : requestParam
   * 작성자 : 박은지
   * 변경이력 :
   * @param user
   * @param page
   * @return
   * Method 설명 : @RequestParam 어노테이션 테스트
   */
   @RequestMapping("requestParam")
   public String requestParam(@RequestParam(name = "userId") String user,
                        @RequestParam(defaultValue = "10") int page) {
      logger.debug("userId : {} " , user);
      logger.debug("page : {} " , page);
      
      return "mvc/view";
   }
   
   
   // mvc/
   @RequestMapping("/path/{subpath}")
   public String requestPath(@PathVariable(name = "subpath") String subpath) {
      
      logger.debug("subpath : {} " , subpath);
      return "mvc/view";
   }
   
   @RequestMapping("upload")
   public String upload(String userId, @RequestPart("picture") MultipartFile partFile) {
	   
	   logger.debug("userId : {}", userId);
	   logger.debug("partFile.getName() : {}", partFile.getName());
	   logger.debug("partFile.getOriginalFilename() : {}", partFile.getOriginalFilename());
	   
	   // 업로드 되는 시점의 년/월 폴더를 생성해주고, 파일경로롸 파일정보를  FileInfo 객체에 담아 리턴
	   FileInfo fileInfo = FileUtil.getFileInfo(partFile.getOriginalFilename());
	   
	   try {
		partFile.transferTo(fileInfo.getFile());
	   } catch (IllegalStateException | IOException e) {
		   e.printStackTrace();
	   }
	   
	   return "mvc/view";
   }
   
   @RequestMapping("multiParameter")
   public String multiParameter(String userId, 
		   						@RequestParam("userId") List<String> userIdList,
		   						Main main) {
	   
	   logger.debug("userId : {}", userId);
	   logger.debug("userIdList : {}, {}", userIdList.get(0), userIdList.get(1));
	   logger.debug("main : {}", main);
	   
	   return "mvc/view";
   }
   
   @RequestMapping("redirect")
   public String redirect(String userId, Model model, HttpSession session, RedirectAttributes reAttr) {
	   
	   //model.addAttribute("userId", userId);
	   //session.setAttribute("userId", userId);
	   
	   // redirect시 최초 1회에 한헤 해당 속성값을 유지하고, 읽혀지면 자동적으로 세션에 해당 속성을 제거한다.
	   reAttr.addFlashAttribute("userId", userId);
	   
	   // 리다이렉트시 파라미터로 전달
	   reAttr.addAttribute("alias", "bear");
	   
	   return "redirect:/login";
	   
	   // redirect : "redirect:url주소";
	   // forward : "forward:url주소";	// 다른 컨트롤러로 forward 
	   // 원본 요청 get 이면 forward 메소드 get (http method에 대해 고려해야함) 
   }
   
}