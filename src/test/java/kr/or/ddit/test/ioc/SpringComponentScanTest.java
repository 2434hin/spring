package kr.or.ddit.test.ioc;
import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/ioc/Component-scan-test.xml")
public class SpringComponentScanTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringComponentScanTest.class);
	
	@Resource(name = "userDao")
	private IUserDao userDao;
	
	@Resource(name = "userService")
	private IUserService userService;

	/**
	 * 
	 * Method : springBeanComponentScanTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 스프링 빈 컴포넌트 스캔 테스트
	 */
	@Test
	public void springBeanComponentScanTest() {
		/***Given***/

		/***When***/
		logger.debug("userService.getUserList() : {}",userService.getUserList());

		/***Then***/
		assertNotNull(userDao);
		assertNotNull(userService);
	}

}
