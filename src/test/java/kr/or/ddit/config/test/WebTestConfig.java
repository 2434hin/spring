package kr.or.ddit.config.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:kr/or/ddit/config/spring/context-root.xml",
		"classpath:kr/or/ddit/config/spring/context-datasource-test.xml",
		"classpath:kr/or/ddit/config/spring/context-transaction.xml",
		"classpath:kr/or/ddit/config/spring/servlet-context.xml"})	// controller scan : servlet-context.xml
@WebAppConfiguration	// 스프링 컨테이너를 구성할 web기반 application context로 구성
public class WebTestConfig {
	
	// controller를 테스트 하기 위해 필요한 것 2가지
	// applicationContext : 스프링 컨테이너
	// MockMvc : dispatcherServlet (applicationContext객체를 통해 설정) 
	
	// 주입하려고하는 필드의 타입과 일치할 경우 이름과 관계없이 주입
	// 만약 주입하려고 하는 필드의 타입과 스프링 빈 중에 타입이 일치하는 빈이 2개이상 존재할 경우 에러
	@Autowired	
	private WebApplicationContext context;

	// 접근제어자 : private(접근불가) 
	//			protected(상속 받은 녀석들은 접근가능) 
	//			default(같은 패키지의 클래스들은 접근 가능) 
	//			public(제한 없음)
	
	protected MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Ignore
	@Test
	public void dummy() {}
}
