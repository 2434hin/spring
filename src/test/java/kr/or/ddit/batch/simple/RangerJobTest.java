package kr.or.ddit.batch.simple;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/context-batch.xml"})
public class RangerJobTest {
	
	// 스프링 컨테이너에 하나의 job이 있을 때 테스트가 가능한 방법
	// 여러개의 테스트가 있을 경우 개별 job과, jobLauncher를 주입받아서 직접 실행
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Test
	public void rangerJobTest() throws Exception {
		/***Given***/

		/***When***/
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		
		/***Then***/
		assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}

}
