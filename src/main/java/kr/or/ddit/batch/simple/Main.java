package kr.or.ddit.batch.simple;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/config/spring/context-batch.xml");
		
		// jobLauncher, job
		JobLauncher jobLauncher = context.getBean("jobLauncher", JobLauncher.class);
		Job RangerJob = context.getBean("rangerJob", Job.class);
		
		try {
			jobLauncher.run(RangerJob, new JobParameters());
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}

}
