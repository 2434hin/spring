package kr.or.ddit.lprod.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.config.test.WebTestConfig;

public class LprodControllerTest extends WebTestConfig{

	/**
	 * 
	 * Method : lprodListTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 전체 제품 그룹 리스트 조회 테스트
	 */
	@Test
	public void lprodListTest() throws Exception {
		/***Given***/
		
		/***When***/
		mockMvc.perform(get("/lprod/lprodList"))
				.andExpect(model().attributeExists("lprodList"))
				.andExpect(view().name("lprod/lprodList"));
		
		/***Then***/

	}
	
	/**
	 * 
	 * Method : lprodPagingListTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 제품 그룹 페이징 리스트 조회 테스트
	 */
	@Test
	public void lprodPagingListTest() throws Exception {
		/***Given***/
		
		/***When***/
		mockMvc.perform(get("/lprod/lprodPagingList"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("lprodList"))
				.andExpect(view().name("lprod/lprodPagingList"));
		
		/***Then***/

	}

}
