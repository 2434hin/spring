package kr.or.ddit.batch.user;

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
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/context-batch.xml",
								   "classpath:kr/or/ddit/config/spring/context-datasource.xml"})
public class UpdatePassJobTest {
	
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void updatePassJobTest() throws Exception {
		/***Given***/

		/***When***/
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		
		/***Then***/
		assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());

	}

}
