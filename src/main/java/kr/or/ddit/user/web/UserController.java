package kr.or.ddit.user.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.model.UserValidator;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.util.FileUtil;
import kr.or.ddit.util.model.FileInfo;

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
	//@GetMapping("userList")
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
	public String userPagingList(@RequestParam(name="page", defaultValue = "1") int p, 
								 @RequestParam(defaultValue = "10")int pagesize, Model model) {
	//public String userPagingList(Page page, Model model) {

		Page page = new Page(p, pagesize);
		model.addAttribute("pageVo", page);
		  
		Map<String, Object> resultMap = userService.getUserPagingList(page);
		  
		model.addAllAttributes(resultMap);
		
		return "user/userPagingList";
	}
	
	/**
	 * 
	 * Method : user
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param userId
	 * @param model
	 * @return
	 * Method 설명 : 사용자 상세조회
	 */
	@RequestMapping(path = "user", method = RequestMethod.GET)
	public String user(String userId, Model model) {

		model.addAttribute("user", userService.getUser(userId));
		
		return "user/user";
	}
	
	/**
	 * 
	 * Method : userPicture
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param userId
	 * @param response
	 * @throws IOException
	 * Method 설명 : 사용자 사진 정보 조회
	 */
	@RequestMapping(path = "userPicture", method = RequestMethod.GET)
	public void userPicture(String userId, HttpServletResponse response) throws IOException {

		User user = userService.getUser(userId);

		ServletOutputStream sos =  response.getOutputStream();

		File picture = new File(user.getRealfilename());

		FileInputStream fis = new FileInputStream(picture);

		byte[] buff = new byte[512];
		int len = 0;

		while((len = fis.read(buff, 0, 512)) != -1) {
			sos.write(buff, 0, len);
		}

		fis.close();
		
	}
	
	/**
	 * 
	 * Method : userForm
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param userId
	 * @param model
	 * @return 
	 * Method 설명 : 사용자 등록 화면
	 */
	@RequestMapping(path = "userForm", method = RequestMethod.GET)
	public String userFormView(String userId, Model model) {

		return "user/userForm";
	}
	
	/**
	 * 
	 * Method : userForm
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 등록 처리
	 */
	@RequestMapping(path = "userForm", method = RequestMethod.POST)
	public String userForm(User user, BindingResult result, 
						   @RequestPart("picture") MultipartFile picture) {

		new UserValidator().validate(user, result);
		
		if(result.hasErrors()) {
			return "user/userForm";
		} else {
			FileInfo fileInfo = FileUtil.getFileInfo(picture.getOriginalFilename());		
			
			// 첨부된 파일이 있을 경우만 업로드 처리
			if (picture.getSize() > 0) {
				try {
					picture.transferTo(fileInfo.getFile());
					user.setFilename(fileInfo.getOriginalFileName());	// OriginalFileName
					user.setRealfilename(fileInfo.getFile().getPath());
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			
			int insertCnt = userService.insertUser(user);
			
			if(insertCnt == 1) {
				// redirect
				return "redirect:/user/user?userId=" + user.getUserId();
			} else {
				// forward
				return "user/userForm";
			}
		}
	}
	
	/**
	 * 
	 * Method : userModifyView
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param userId
	 * @param model
	 * @return
	 * Method 설명 : 사용자 수정 화면
	 */
	@RequestMapping(path = "userModify", method = RequestMethod.GET)
	public String userModifyView(String userId, Model model) {

		model.addAttribute("user", userService.getUser(userId));

		return "user/userModify";
	}
	
	@RequestMapping(path = "userModify", method = RequestMethod.POST)
	public String userModify(User user, @RequestPart("picture") MultipartFile picture) {
		
		FileInfo fileInfo = FileUtil.getFileInfo(picture.getOriginalFilename());		
		
		// 첨부된 파일이 있을 경우만 업로드 처리
		if (picture.getSize() > 0) {
			try {
				picture.transferTo(fileInfo.getFile());
				user.setFilename(fileInfo.getOriginalFileName());	// OriginalFileName
				user.setRealfilename(fileInfo.getFile().getPath());
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		} else {		
			User userFile = userService.getUser(user.getUserId());
			
			user.setFilename(userFile.getFilename());
			user.setRealfilename(userFile.getRealfilename());
		}
		
		int updateCnt = userService.updateUser(user);
		
		if(updateCnt == 1) {
			// redirect
			return "redirect:/user/user?userId=" + user.getUserId();
		} else {
			// forward
			return "user/userModify";
		}

	}
}
