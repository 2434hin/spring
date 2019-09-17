package kr.or.ddit.login.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.config.test.WebTestConfig;
import kr.or.ddit.user.model.User;

public class LoginControllerTest extends WebTestConfig{

	/**
	 * 
	 * Method : loginViewTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 로그인 화면 요청 테스트
	 * @throws Exception 
	 */
	@Test
	public void loginViewTest() throws Exception {
		/***Given***/

		/***When***/
		MvcResult mcvResult = mockMvc.perform(get("/login")).andReturn();
		ModelAndView mav = mcvResult.getModelAndView();

		/***Then***/
		assertEquals("login/login", mav.getViewName());
	}
	
	/**
	 * 
	 * Method : loginProcessTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 로그인 요청 처리 테스트
	 */
	@Test
	public void loginProcessTest() throws Exception {

		MockHttpSession session = new MockHttpSession();
		
		mockMvc.perform(post("/login").param("userId", "brown")
									  .param("pass", "brown1234")
									  .session(session))
			   .andExpect(status().isOk())
			   .andExpect(view().name("main"));
			   //.andExpect(request().sessionAttribute("S_USERVO", matcher));
		
		User user = (User) session.getAttribute("S_USERVO");
		
		assertNotNull(user);
	}

}
